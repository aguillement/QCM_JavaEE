CREATE PROCEDURE PROC_GENERATE_QUESTIONS (@IDTest INT, @IDTheme INT)
AS
BEGIN
	SELECT T2.id
	, T2.statement
	, T2.idTheme
	, T2.media
	, T2.points
	, T2.nbQuestionToDraw
	FROM QUESTION WITH (NOLOCK)
		JOIN
		(
		SELECT T1.id
		, T1.statement
		, T1.idTheme
		, T1.media
		, T1.points
		, T1.nbQuestionToDraw
		, ROW_NUMBER() OVER (ORDER BY NEWID()) as r
		FROM QUESTION WITH (NOLOCK)
			JOIN 
			(
			SELECT *
			FROM (
			SELECT  QUESTION.id 
			, QUESTION.statement
			, QUESTION.idTheme 
			, QUESTION.media
			, QUESTION.points
			, TEST_SECTION.nbQuestionToDraw
			, ROW_NUMBER() OVER(PARTITION BY QUESTION.id ORDER BY ID DESC) rn
			FROM QUESTION WITH (NOLOCK)
				JOIN TEST_SECTION WITH (NOLOCK) ON TEST_SECTION.idTheme = TEST_SECTION.idTheme
			WHERE TEST_SECTION.idTest = @IDTest
			AND QUESTION.idTheme = @IDTheme
			)  QUESTION_DISTINCT_BY_ID
			WHERE rn = 1
			) AS T1 ON T1.id = QUESTION.id
		) AS T2 ON T2.id = QUESTION.id
	WHERE T2.r <= T2.nbQuestionToDraw
END
	
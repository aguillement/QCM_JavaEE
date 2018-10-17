CREATE FUNCTION FT_GET_RESULT_EXAM(@IDExam INT)
RETURNS TABLE  
AS  
RETURN   
(  
	SELECT
	CASE 
		WHEN EXAM.score >= TEST.high_level THEN 'ACQUIS'
		WHEN EXAM.score < TEST.high_level AND EXAM.score >= TEST.low_level THEN 'EN COURS'
		ELSE 'NON ACQUIS'
	END as Result,
	T1.nbQuestion,
	EXAM.id as IdExam,
	Test.label,
	T2.nbRightQuestion,
	T3.nbAnsweredQuestion
	FROM EXAM	
		JOIN TEST ON TEST.id = EXAM.idTest
		JOIN
		(
			SELECT COUNT(*) as nbQuestion, idExam 
			FROM DRAW_QUESTION WHERE idExam = @IDExam
			GROUP BY idExam
		) T1 ON T1.idExam = EXAM.id
		JOIN
		(
			SELECT  Count(*) as nbRightQuestion, DRAW_ANSWER.idExam
			FROM DRAW_ANSWER
				JOIN PROPOSITION ON PROPOSITION.id = DRAW_ANSWER.idProposition
			WHERE PROPOSITION.isTrue = 1
			GROUP BY DRAW_ANSWER.idExam
		) T2 ON T2.idExam = EXAM.id
		JOIN
		(
			SELECT Count(*) as nbAnsweredQuestion, idExam
			FROM DRAW_ANSWER WHERE idExam = @IDExam
			GROUP BY idExam
		) T3 ON T3.idExam = EXAM.id
	WHERE EXAM.id= @IDExam
);  
CREATE PROCEDURE PROC_GENERATE_QUESTIONSV2 (@IDTest INT)
AS
BEGIN

	SET NOCOUNT ON
	DECLARE @IDTest_cursor INT
	DECLARE @IDTheme_cursor INT

	DECLARE test_cursor CURSOR FOR 
	SELECT TEST_SECTION.idTest
	, TEST_SECTION.idTheme
		FROM TEST_SECTION
		WHERE TEST_SECTION.idTest = @IDTest

	CREATE TABLE #section_test
	(
	   id					INT
	   , statement			VARCHAR(500)
	   , idTheme			INT
	   , media				INT
	   , points				INT
	   , nbQuestionToDraw	INT
	)

	OPEN test_cursor  
	FETCH NEXT FROM test_cursor INTO @IDTest_cursor, @IDTheme_cursor  

	WHILE @@FETCH_STATUS = 0  
	BEGIN  
		  INSERT INTO #section_test
		  EXEC PROC_GENERATE_QUESTIONS @IDTest_cursor, @IDTheme_cursor      

		  FETCH NEXT FROM test_cursor INTO @IDTest_cursor, @IDTheme_cursor   
	END 

	CLOSE test_cursor  
	DEALLOCATE test_cursor 

	SELECT * FROM #section_test

END
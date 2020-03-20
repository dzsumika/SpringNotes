<html>

	<head>
		<style>
			.wrapper {
				margin-left: 30%;
				margin-right: 30%;
			}
		</style>
	</head>

	<body>
		<div class="wrapper">
			<form action="addNote" method="POST">
				<h1>Add a new note:</h1>
				<br>
				<input type="text" name="note_header">
				<br>
				<textarea name="note" rows="4" cols="50"></textarea>
				<br>
				<input type="submit">
			</form>
			
			<form action="showNotes">
				<h1>Show my notes</h1>
				<input type="submit">
			</form>
		</div>
	</body>
</html>

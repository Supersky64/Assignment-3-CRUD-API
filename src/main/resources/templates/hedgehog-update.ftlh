<!--New Hedgehog Form screen for Hedgehog Showcase web app-->
<!DOCTYPE html>
<html lang="en">

<!--New Hedgehog Form of html for home page. Imports Bootstrap 5.3.8 CSS and local style.css-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>Update hedgehog Form</title>
</head>

<body>

 <!-- Begin Nav Bar -->
       <nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/hedgehog" title="Homepage">
            <img src="https://gregrichdvm.com/wp-content/uploads/2022/09/hedgehog.jpg" 
                 alt="Logo" width="50" height="50" class="d-inline-block align-middle">
            The Hedgehog Gallery
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/hedgehog" title="Homepage">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/hedgehog/createForm" title="New Hedgehog">Submit a Hedgehog</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- End Nav Bar -->

  <form id="new-hedgehog" action="/hedgehog/update/${hedgehog.hedgehogId}" method="post">
      <div class="form-group">
        <label for="hedgehogName">Hedgehog Name</label>
        <input type="text" class="form-control" id="name" aria-describedby="nameHelp" name="name" value="${hedgehog.name}" placeholder="Enter Hedgehog Name">
        <small id="nameHelp" class="form-text text-muted">What is the name of the hedgehog?</small>
      </div>
      <div class="form-group">
        <label for="hedgehogDesc">Hedgehog Description</label>
        <input type="text" class="form-control" id="description" aria-describedby="summaryHelp" name="description" value="${hedgehog.description}" placeholder="Enter hedgehog Description">
        <small id="summaryHelp" class="form-text text-muted">Enter a brief summary for the hedgehog.</small>
      </div>
      <div class="form-group">
        <label for="hedgehogDetails">Hedgehog Breed</label>
        <input type="text" class="form-control" id="Breed" aria-describedby="breedHelp" name="breed" value="${hedgehog.breed}" placeholder="Enter Hedgehog Breed">
        <small id="breedHelp" class="form-text text-muted">Enter hedgehog breed.</small>
      </div>
      <div class="form-group">
        <label for="hedgehogDetails">Hedgehog Age</label>
        <input type="number" class="form-control" id="age" aria-describedby="ageHelp" name="age" value="${hedgehog.age}" placeholder="Enter Hedgehog Age">
        <small id="ageHelp" class="form-text text-muted">Enter hedgehog age.</small>
      </div>
      <div class="form-group">
        <label for="hedgehogImage">Hedgehog Image</label>
        <input type="text" class="form-control" id="image" name="image" placeholder="Enter URL of image of Hedgehog">
        <small id="imageHelp" class="form-text text-muted">Enter a URL of the image of the hedgehog you want to add.</small>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
      <a href="/hedgehog/delete/${hedgehog.hedgehogId}" class="btn btn-danger">Delete</a>
  </form>
</body>

</html>
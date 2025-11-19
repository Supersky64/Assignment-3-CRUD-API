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
            <a class="navbar-brand" href="index.html" title="Homepage">
                <img src="https://gregrichdvm.com/wp-content/uploads/2022/09/hedgehog.jpg" alt="Logo" width="50" height="50"
                    class="d-inline-block align-middle">
                The Hedgehog Gallery
            </a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html" title="Homepage">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="details.html"
                            title="This months Hedgehog">Featured</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html" title="About">About me</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="new-hedgehog-form.html" title="New Hedgehog">Submit a Hedgehog</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin.html" title="Admin page">Admin</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
<!-- End Nav Bar -->

  <div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <img src="/profile-pictures/${(hedgehog.profilePicturePath)!'avatar.png'}" class="card-img-top"
      style="height: 100px; width: 100px;" alt="profile picture">
    <form id="new-hedgehog" action="/hedgehog/update/${hedgehog.hedgehogId?c}" method="post" enctype="multipart/form-data">
      <input type="text" id="hedgehogId" name="hedgehogId" value="${hedgehog.hedgehogId?c}" readonly />
      <input type="text" id="name" name="name" value="${hedgehog.name}" placeholder="Name" />
      <input type="text" id="description" name="description" value="${hedgehog.description}" placeholder="Hedgehog Description" />
      <input type="text" id="breed" name="breed" value="${hedgehog.breed}" placeholder="Breed" />
      <input type="number" id="age" name="age" step="0.1" value="${hedgehog.age}" placeholder="Age" /><br>
      <label for="profilePicturePath" class="form-label">Current Picture</label>
      <input type="text" id="profilePicturePath" name="profilePicturePath" value="${(hedgehog.profilePicturePath)}" readonly />
      <input type="file" id="picture" name="picture" />
      <button type="submit" class="btn btn-primary">Save</button>
      <a href="/hedgehog/${hedgehog.hedgehogId?c}" class="btn btn-outline-danger">Cancel</a>
    </form>

  </div>
</body>

</html>
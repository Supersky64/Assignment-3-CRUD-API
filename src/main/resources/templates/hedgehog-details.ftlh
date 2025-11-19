<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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
                        <a class="nav-link" href="new-animal-form.html" title="New Hedgehog">Submit a Hedgehog</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin.html" title="Admin page">Admin</a>
                    </li>

                </ul>



            </div>

        </div>
    </nav>
<!-- End Nav Bar -->

    <div class="container mt-4">
        <figure class="text-center">
            <h1>${title}</h1>
        </figure>


        

    <ul class="nav justify-content-center">
    <li>
        <div class="card" style="width: 18rem;">
          <img class="card-img-top" src=${hedgehog.image} alt="The Hedgehog">
          <div class="card-body">
          <h2">${hedgehog.name}</h2>
          <p class="card-text">
            <b>Breed: </b> ${hedgehog.breed}
          </p>
          <p class="card-text">
            <b>Age: </b> ${hedgehog.age}
          </p>
          <p class="card-text">
            ${hedgehog.description}
          </p>
          <a href="/hedgehog/updateForm/${hedgehog.hedgehogId}" class="btn btn-primary">Edit</a>
          <a href="/hedgehog/delete/${hedgehog.hedgehogId?c}" class="btn btn-danger">Delete Hedgehog</a>
          <a href="/hedgehog" class="btn btn-primary">Go back home</a>
          
          </div>
        </div>
    </li>
    </ul>


    </div>


    <footer class="bg-dark text-light text-center py-3">
        <p class="mb-0">&copy; 2025 [Bryan Palma]. All Rights Not Reserved.</p>
    </footer>
</body>

</html>
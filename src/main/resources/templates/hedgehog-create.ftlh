<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Animal</title>
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

<div class="container" style="margin-top: 15px;" >
    <h1>${title}</h1>
    <form id="new-hedgehog" action="/hedgehog" method="post" enctype="multipart/form-data">
        <input type="text" id="name" name="name" placeholder="Name"/>
        <input type="text" id="description" name="description" placeholder="Enter Hedgehog Description/>
        <input type="text" id="breed" name="breed" placeholder="Breed"/>
        <input type="number" id="age" name="age" step="0.1" placeholder="Age"/>
        <input type="file" id="picture" name="picture" required/>
        <button type="submit" class="btn btn-primary">Save</button>
       <a href="/hedgehog" class="btn btn-outline-danger" >Cancel</a>
    </form>

</div>

<footer class="bg-dark text-light text-center py-3">
        <p class="mb-0">&copy; 2025 [Bryan Palma]. All Rights Not Reserved.</p>
    </footer>
</body>
</html>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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

<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <a href="/hedgehog/createForm" class="btn btn-outline-primary" style="float:right;">Create New Hedgehog</a>

    <form action="/hedgehog/name">
        <input type="text" name="key" placeholder="Search By Name &#128270;">
    </form>


     <ul id= "hedgehogList" class="nav justify-content-center">
    <#list hedgehogs as hedgehog>
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="${hedgehog.image}" alt="Card image cap">
            <div class="card-body">
            <h5 class="card-title">${hedgehog.name}</h5>
            <a href="/hedgehog/${hedgehog.hedgehogId}" class="btn btn-primary">View Details</a>

            </div>
        </div>
    </#list>
    </ul>
  

    <footer class="bg-dark text-light text-center py-3">
        <p class="mb-0">&copy; 2025 [Bryan Palma]. All Rights Not Reserved.</p>
    </footer>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</body>

</html>
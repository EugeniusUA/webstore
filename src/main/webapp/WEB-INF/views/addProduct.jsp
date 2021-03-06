<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
    <title>Products - Add Product</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add products</p>
        </div>
        <a href="<c:url value="/j_spring_security_logout" />" class="btn btndanger btn-mini pull-right">logout</a>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new product</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2"
                       for="productId"><spring:message code= "addProduct.form.productId.label"/> </label>

                <div class="col-lg-10">
                    <form:input id="productId" path="productId" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="col-lg-10">
                <label class="control-label col-lg-2 col-lg-2"
                       for="productId">Product Name</label>
                <div class="col-lg-10">
                <form:input id="name" path="name" type="text"
                            class="form:input-large"/>
                </div>
            </div>

                <div class="col-lg-10">
                    <label class="control-label col-lg-2 col-lg-2"
                           for="unitPrice">Product Price</label>
                    <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text"
                                class="form:input-large"/>
                    </div>
                </div>

            <div class="col-lg-10">
                <label class="control-label col-lg-2 col-lg-2"
                       for="manufacturer">Product Manufacturer</label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="col-lg-10">
                <label class="control-label col-lg-2 col-lg-2"
                       for="category">Product Category</label>
                <div class="col-lg-10">
                    <form:select path="category">
                        <form:option selected="selected" value="Laptop">Laptop</form:option>
                        <form:option value="Tablet">Tablet</form:option>
                        <form:option value="Smart Phone">Smart Phone</form:option>
                    </form:select>
                </div>
            </div>

            <div class="col-lg-10">
                <label class="control-label col-lg-2 col-lg-2"
                       for="unitsInStock">Products in Stock</label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2"
                       for="description">Description</label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2">Condition</label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/>New
                    <form:radiobutton path="condition" value="Old"/>Old
                    <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProdcut.form.productImage.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file"
                                class="form:input-large" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>

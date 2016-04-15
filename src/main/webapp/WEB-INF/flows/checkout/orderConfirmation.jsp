<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=" utf-
          8
    ">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Order Confirmation</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Order</h1>
            <p>Order Confirmation</p>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <form:form modelAttribute="order" class="form-horizontal">
        <input type="hidden" name="_flowExecutionKey"
               value="${flowExecutionKey}"/>
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1
col-sm-offset-1 col-md-offset-3">
            <div class="text-center">
                <h1>Receipt</h1>
            </div>
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>Shipping Name</strong>
                        <br>${order.shippingDetail.name}<br>
                        <strong>Shipping Address</strong>
                        <br>${order.shippingDetail.shippingAddress}<br>
                        <strong>Shipping Date</strong>
                        <br>${order.shippingDetail.shippingDate}<br>
                        <button id="back" class="btn btn-default"
                                name="_eventId_backToCollectShippingDetail">back
                        </button>
                        <button type="submit" class="btn btn-success"
                                name="_eventId_orderConfirmed">
                            Confirm <span class="glyphicon glyphicon-chevronright"></span>
                        </button>
                        <button id="btnCancel" class="btn btn-default"
                                name="_eventId_cancel">Cancel
                        </button>
                </div>
            </div>
            </form:form>
        </div>
    </div>
</body>
</html>
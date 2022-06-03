<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Page Not Found</title>--%>
<%--    <link href="css/style.css" rel="stylesheet" type="text/css"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<header>--%>
<%--    <h1>Welcome to Bookstore.com</h1>--%>
<%--    <nav>--%>
<%--        <a href="http://localhost:8090/bookstore.com/controller?command=books"> Books </a>--%>
<%--        <a href="http://localhost:8090/bookstore.com/controller?command=users"> Users </a>--%>
<%--        <a href="http://localhost:8090/bookstore.com/controller?command=orders"> Orders </a>--%>
<%--    </nav>--%>
<%--</header>--%>
<%--<div class="error">--%>
<%--    Error!!!!--%>
<%--    <br/>--%>
<%--    ${message}--%>
<%--</div>--%>
<%--</br>--%>
<%--<a href="http://localhost:8090/bookstore.com"> Back to main Page </a>--%>
<%--<jsp:include page="footer.jsp"/>--%>
<%--</body>--%>

<html style="font-size: 16px;">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="404">
    <meta name="description" content="">
    <title>Page Not Found</title>
    <link rel="stylesheet" href="/nicepage.css" media="screen">
    <script class="u-script" type="text/javascript" src="np://app.desktop.nicepage.com/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="np://app.desktop.nicepage.com/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.11.3, nicepage.com">
</head>
<body class="u-body" data-style="page-404-template-1" data-posts=""
      data-global-section-properties="{&quot;code&quot;:&quot;PAGE_404&quot;,&quot;colorings&quot;:{&quot;light&quot;:[&quot;clean&quot;,&quot;clean&quot;],&quot;colored&quot;:[&quot;clean&quot;,&quot;clean&quot;,&quot;clean&quot;],&quot;dark&quot;:[&quot;clean&quot;,&quot;clean&quot;,&quot;clean&quot;]},&quot;isPreset&quot;:true}"
      data-source="fix"
      data-page-sections-style="[{&quot;name&quot;:&quot;page-404-1&quot;,&quot;margin&quot;:&quot;both&quot;,&quot;repeat&quot;:false}]"
      data-page-coloring-types="{&quot;light&quot;:[&quot;clean&quot;,&quot;clean&quot;],&quot;colored&quot;:[&quot;clean&quot;,&quot;clean&quot;,&quot;clean&quot;],&quot;dark&quot;:[&quot;clean&quot;,&quot;clean&quot;,&quot;clean&quot;]}"
      data-page-category="404">
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<section class="u-align-center u-clearfix u-block-f8c9-9" custom-posts-hash="T"
         data-section-properties="{&quot;margin&quot;:&quot;both&quot;,&quot;stretch&quot;:true}" data-id="f8c9"
         data-style="page-404-1" id="sec-0bc4">
    <div class="u-clearfix u-sheet u-valign-middle u-block-f8c9-2 main">
        <h1 class="u-text u-text-default u-block-f8c9-11">${pageContext.response.status}</h1>
        <p class="u-text u-text-default u-text-not-found-message u-block-f8c9-10">
            ${message}
        </p>
        <p class="u-text u-block-f8c9-5">The page you are looking for was moved, removed, renamed or might never
            existed</p>
        </br>
        </br>

        <a href="http://localhost:8090/bookstore.com"
           class="u-active-white u-black u-border-2 u-border-active-black u-border-black u-border-hover-black u-btn u-button-style u-hover-white u-text-active-black u-text-body-alt-color u-text-hover-black u-block-f8c9-6">Go
            to homepage</a>
    </div>
    <jsp:include page="footer.jsp"/>
    <style data-mode="XL">@media (min-width: 1200px) {
        .u-block-f8c9-9 {
            background-image: none;
        }

        .u-block-f8c9-2 {
            min-height: 100vh;
        }

        .u-block-f8c9-11 {
            font-size: 12.5rem;
            font-weight: 700;
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-10 {
            font-size: 1.875rem;
            font-weight: 700;
            line-height: 1;
            text-transform: uppercase;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-5 {
            background-image: none;
            font-size: 1.5rem;
            width: 525px;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-6 {
            border-style: solid;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 4px;
            background-image: none;
            align-self: center;
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 60px;
            padding-top: 10px;
            padding-right: 54px;
            padding-bottom: 10px;
            padding-left: 52px;
        }
    }</style>
    <style data-mode="LG">@media (max-width: 1199px) and (min-width: 992px) {
        .u-block-f8c9-9 {
            background-image: none;
        }

        .u-block-f8c9-2 {
            min-height: 100vh;
        }

        .u-block-f8c9-11 {
            font-size: 12.5rem;
            font-weight: 700;
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-10 {
            font-size: 1.875rem;
            font-weight: 700;
            line-height: 1;
            text-transform: uppercase;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-5 {
            background-image: none;
            font-size: 1.5rem;
            width: 525px;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-6 {
            background-image: none;
            border-style: solid;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 4px;
            align-self: center;
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 60px;
            padding-top: 10px;
            padding-right: 54px;
            padding-bottom: 10px;
            padding-left: 52px;
        }
    }</style>
    <style data-mode="MD">@media (max-width: 991px) and (min-width: 768px) {
        .u-block-f8c9-9 {
            background-image: none;
        }

        .u-block-f8c9-2 {
            min-height: 100vh;
        }

        .u-block-f8c9-11 {
            font-size: 12.5rem;
            font-weight: 700;
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-10 {
            font-size: 1.875rem;
            font-weight: 700;
            line-height: 1;
            text-transform: uppercase;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-5 {
            background-image: none;
            font-size: 1.5rem;
            width: 525px;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-6 {
            background-image: none;
            border-style: solid;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 4px;
            align-self: center;
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 60px;
            padding-top: 10px;
            padding-right: 54px;
            padding-bottom: 10px;
            padding-left: 52px;
        }
    }</style>
    <style data-mode="SM" data-visited="true">@media (max-width: 767px) and (min-width: 576px) {
        .u-block-f8c9-9 {
            background-image: none;
        }

        .u-block-f8c9-2 {
            min-height: 599px;
        }

        .u-block-f8c9-11 {
            font-size: 12.5rem;
            font-weight: 700;
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-10 {
            font-size: 1.875rem;
            font-weight: 700;
            line-height: 1;
            text-transform: uppercase;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-5 {
            background-image: none;
            font-size: 1.5rem;
            width: 525px;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-6 {
            background-image: none;
            border-style: solid;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 4px;
            align-self: center;
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 60px;
            padding-top: 10px;
            padding-right: 54px;
            padding-bottom: 10px;
            padding-left: 52px;
        }
    }</style>
    <style data-mode="XS" data-visited="true">@media (max-width: 575px) {
        .u-block-f8c9-9 {
            background-image: none;
        }

        .u-block-f8c9-2 {
            min-height: 525px;
        }

        .u-block-f8c9-11 {
            font-size: 7.5rem;
            font-weight: 700;
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-10 {
            font-size: 1.5rem;
            font-weight: 700;
            line-height: 1;
            text-transform: uppercase;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-5 {
            background-image: none;
            font-size: 1.25rem;
            width: 340px;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 0;
        }

        .u-block-f8c9-6 {
            background-image: none;
            border-style: solid;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 4px;
            align-self: center;
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 60px;
            padding-top: 10px;
            padding-right: 54px;
            padding-bottom: 10px;
            padding-left: 52px;
        }
    }</style>
</section>
</body>
</html>
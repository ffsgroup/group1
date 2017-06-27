<%-- 
    Document   : homeAboutUs
    Created on : Jun 19, 2017, 2:18:03 PM
    Author     : user149
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About US</title>

        <link rel="stylesheet" href="resources/main.css" />


        <!-- Scripts -->
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <!--<script src="resources/jquery.min.js"></script>-->
        <script src="resources/jquery.dropotron.min.js"></script>
        <script src="resources/skel.min.js"></script>
        <script src="resources/util.js"></script>

        <script src="resources/main.js"></script>
    </head>
    <body>
        <div id="page-wrapper">

            <!-- Header -->
            <div id="header" style="background-color: grey" >

                <!-- Logo -->
                <h1><a href="${pageContext.request.contextPath}/#" id="logo">INTRANET SOLUTIONS <em>(Pty) LTD</em></a></h1>

                <!-- Nav -->
                <nav id="nav">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/#">Home</a></li>
                        <li>
                            <a href="#">Products</a>
                            <ul>
                                <li><a href="#">Dairy</a></li>

                                <li><a href="#">Task Manager</a></li>
                                <!--                            <li>
                                                                <a href="#">Task Manager</a>
                                                                <ul>
                                                                    <li><a href="#">Lorem dolor</a></li>
                                                                    <li><a href="#">Phasellus magna</a></li>
                                                                    <li><a href="#">Magna phasellus</a></li>
                                                                    <li><a href="#">Etiam nisl</a></li>
                                                                    <li><a href="#">Veroeros feugiat</a></li>
                                                                </ul>
                                                            </li>-->

                            </ul>
                        </li>
                        <li class="current"><a href="${pageContext.request.contextPath}/aboutus">About Us</a></li>
                        <!--                    <li><a href="right-sidebar.html">Contact Us</a></li>-->
                        <!--                    <li><a href="two-sidebar.html">Two Sidebar</a></li>-->
                        <li><a href="${pageContext.request.contextPath}/login">Demo</a></li>
                    </ul>
                </nav>

            </div>

            <!-- Main -->
            <section class="wrapper style1">
                <div class="container">
                    <div id="content">

                        <!-- Content -->

                        <article>
                            <header>
                                <h2>ABOUT US</h2>
<!--                                <p>All content, all the time.</p>-->
                            </header>

                            <span class="image featured"><img src="resources/images/banner.jpg" alt="" /></span>

                            <p>Intranet Solutions is Powering Businesses Through Information and Technology and is driven by the desire to help businesses like yours
                                unlock the power of information and technology – to function optimally. Our services are purposefully designed to let you work smarter, 
                                not harder – from placing useful data at your fingertips – to creating technology platforms to enable business success. 
                                This includes the custom engineering of software, solutions to leverage business intelligence, Task Manager, Diary, 
                                administration of funeral insurance policies and information technology (IT) services.
                               </p>

                            <h3>INDUSTRIES AND CLIENTS</h3>
                            <p>Intranet Solutions has delivered consulting services in the private and corporate sector. We have been consulted to provide consulting and
                                software development services for various corporate firms such as SANLAM SKY, GRADRISK and W J MITCHELL & ASSOCIATES  amongst others.</p>
                            
                            <h3>OUR MISSION</h3>
                            <p>is to continue growing our client base and provide excellent after sales service and support as well as cutting edge technology solutions.</p>
                            
                             <h3>OUR VISION</h3>
                            <p>is to be an industry leader digital agency and software development house.</p>
                        </article>

                    </div>
                </div>
            </section>

             <!-- Footer -->
        <div id="footer">
            <div class="container">
                <div class="row">
                    <section class="3u 6u(narrower) 12u">
                        <h3>Contact</h3>
                        <ul class="links">
                            <li><img src="resources/email-icon.jpg" alt="" width="20" height ="20" /> it@safin.co.za</li>
                            <li><img src="resources/address.jpg" alt="" width="20" height ="20"  />  9 Mack Road, Emapengeni, 3880</li>
                            <li><img src="resources/phone.jpg" alt="" width="20" height ="20"  />  035 772 3226</li>
<!--                            <li><a href="#">Rutrum accumsan dolor</a></li>
                            <li><a href="#">Mattis rutrum accumsan</a></li>
                            <li><a href="#">Suspendisse varius nibh</a></li>
                            <li><a href="#">Sed et dapibus mattis</a></li>-->
                        </ul>
                    </section>
<!--                    <section class="3u 6u 12u">
                        <h3>More Links to Stuff</h3>
                        <ul class="links">
                            <li><a href="#">Duis neque nisi dapibus</a></li>
                            <li><a href="#">Sed et dapibus quis</a></li>
                            <li><a href="#">Rutrum accumsan sed</a></li>
                            <li><a href="#">Mattis et sed accumsan</a></li>
                            <li><a href="#">Duis neque nisi sed</a></li>
                            <li><a href="#">Sed et dapibus quis</a></li>
                            <li><a href="#">Rutrum amet varius</a></li>
                        </ul>
                    </section>-->
                    <section class="6u 12u(narrower)">
                        <h3>Get In Touch</h3>
                        <form>
                            <div class="row 50%">
                                <div class="6u 12u(mobilep)">
                                    <input type="text" name="name" id="name" placeholder="Name" />
                                </div>
                                <div class="6u 12u(mobilep)">
                                    <input type="email" name="email" id="email" placeholder="Email" />
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <textarea name="message" id="message" placeholder="Message" rows="5"></textarea>
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <ul class="actions">
                                        <li><input type="submit" class="button alt" value="Send Message" /></li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>
            </div>

            <!--Icons -->
            <!--                        <ul class="icons">
                                        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                                        <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                                        <li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
                                        <li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
                                        <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
                                    </ul>-->

            <!-- Copyright -->
            <div class="copyright">
                <ul class="menu">
                    <li>  &copy; INTRANET SOLUTIONS (Pty) Ltd. 2017 All rights reserved</li>
                </ul>
            </div>

        </div>

        </div>


    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>FFS GROUP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

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
                    <li class="current"><a href="index.html">Home</a></li>
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
                    <li><a href="${pageContext.request.contextPath}/aboutus">About Us</a></li>
<!--                    <li><a href="right-sidebar.html">Contact Us</a></li>-->
                    <!--                    <li><a href="two-sidebar.html">Two Sidebar</a></li>-->
                    <li><a href="${pageContext.request.contextPath}/login">Demo</a></li>
                </ul>
            </nav>

        </div>

        <!-- Banner -->
        <section id="banner" >
            <center>  
                <h2>FOCUS ON GETTING THINGS DONE</h2>
                <p>The simple, intuitive user interface is designed to help you see exactly what you need to focus on.</p>
            </center>

        </section>

        <!-- Highlights -->
        <section class="wrapper style1">
            <div class="container">
                <div class="row 200%">
                    <section class="4u 12u(narrower)">
                        <div class="box highlight">
                            <img src="resources/benefit3_efficiency.png" alt="" width="100" height ="100" />
                            <!--                            <i class="icon major fa-paper-plane"></i>-->
                            <h3>IMPROVE EFFICIENCY</h3>
                            <p>More focused communication, real-time updates, never miss or forget a task.</p>
                        </div>
                    </section>
                    <section class="4u 12u(narrower)">
                        <div class="box highlight">
                            <img src="resources/benefit3_accountability.png" alt="" width="100" height ="100" />
                            <h3>IMPROVE ACCOUNTABILITY</h3>
                            <p>Through detailed record keeping and reporting.</p>
                        </div>
                    </section>
                    <section class="4u 12u(narrower)">
                        <div class="box highlight">
                            <img src="resources/benefit3_quality.png" alt="" width="100" height ="100"/>
                            <h3>IMPROVE QUALITY</h3>
                            <p>Clearer communication and organisation leads to fewer mistakes.</p>
                        </div>
                    </section>
                </div>
            </div>
        </section>

        <!-- Gigantic Heading -->
        <section class="wrapper style2">
            <div class="container">
                <header class="major">
                    <h2>What you can achieve!</h2>
                    <p></p>
                </header>
            </div>
        </section>

        <!-- Posts -->
        <section class="wrapper style1">
            <div class="container">
                <div class="row">
                    <section class="6u 12u(narrower)">
                        <div class="A">
                            <img src="resources/integrated.png" alt="" width="450" height ="250" />
                            <div class="inner">
                                <h3>ALL IN ONE SOLUTION FOR <em>PRODUCTIVITY</em></h3>
                                <p>No more double entry. No more headaches trying to link separate systems that just don’t quite work right.</p>
                            </div>
                        </div>
                    </section>
                    <section class="6u 12u(narrower)">
                        <div class="">
                            <img src="resources/workload.png" alt="" width="450" height ="250" />
                            <div class="inner">
                                <h3>MANAGE ALL YOUR WORK IN <em>ONE PLACE</em></h3>
                                <p>Traditional project management systems focus only on project work and fail to recognise the other in-house and personal tasks that impact on your daily productivity.</p>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </section>
        <!-- Gigantic Heading -->
        <section class="wrapper style2">
            <div class="container">
                <header class="major">
                    <h2>Features</h2>
                    <p>Some key features</p>
                </header>
            </div>
        </section>
        <!-- Features -->
        <section class="wrapper style1">
            <div class="container">
                <div class="row">
                    <section class="6u 12u(narrower)">
                        <div class="box post">
                            <a href="#" class="image left"><img src="resources/diary.png" alt="" /></a>
                            <div class="inner">
                                <h3>DIARY</h3>
                                <p> Keep your diary, journal, photos and manage appointments all in a single diary software.</p>
                            </div>
                        </div>
                    </section>
                    <section class="6u 12u(narrower)">
                        <div class="box post">
                            <a href="#" class="image left"><img src="resources/Task4.jpg" alt="" /></a>
                            <div class="inner">
                                <h3>TASKS</h3>
                                <p>Track everything you or your employee's does – in-house tasks, personal tasks all in one place.</p>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="row">
                    <section class="6u 12u(narrower)">
                        <div class="box post">
                            <a href="#" class="image left"><img src="resources/document.jpg" alt="" /></a>
                            <div class="inner">
                                <h3>DOCUMENTS</h3>
                                <p>Upload documents to both Task and Dairy modules for all in one solution, Any format may be uploaded.</p>
                            </div>
                        </div>
                    </section>
                    <section class="6u 12u(narrower)">
                        <div class="box post">
                            <a href="#" class="image left"><img src="resources/secure1.jpg" alt="" width="150" height ="150"/></a>
                            <div class="inner">
                                <h3>ACCESS CONTROL</h3>
                                <p>Access are restricted according to their security settings.</p>
                            </div>
                        </div>
                    </section>
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
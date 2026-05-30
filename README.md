# Spring Boot Thymeleaf Web App
## Shows 2 pages: /spring and /greet. 
- **/greet** page allows you to enter your name and see it printed on the page after click on submit button. This achievied by sending a POST method. PagesController will get param from request, put it inside model and then page will be changed.
```
    @PostMapping("/greet")
    public String submitGreet(@RequestParam String name, Model model){
        model.addAttribute("name", name + " (this is msg from POST)");
        return "greet";
```
- **/spring** page simply gets Model and print it inside the header using Thymeleaf: ```<h1 th:text="${msg}"></h1>```
<p align="center">
<img width="800" height="450" alt="ezgif-346c68d7c1af4fcf" src="https://github.com/user-attachments/assets/d24a5764-5de5-4357-97bf-1eb017b722b9" />
</p>


#### How Spring understands that "return "pagename"" in Controller methods - its the pages?
```
HTTP request → DispatcherServlet
             → Controller
             → return "greet"
             → ViewResolver (ThymeleafViewResolver)
             → templates/greet.html
             → Thymeleaf engine
             → HTML response
             ```

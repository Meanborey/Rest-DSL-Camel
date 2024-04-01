package com.example.spring_rest_jpa;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/users")
                .get("/all")
                .to("direct:getUsers");
//                .post()
//                .to("direct:createUser")
//                .put()
//                .to("direct:updateUser")
//                .delete()
//                .to("direct:deleteUser");

        from("direct:getUsers")
                .to("jpa:User");

//        from("direct:createUser")
//                .to("jpa:persist");
//
//        from("direct:updateUser")
//                .to("jpa:merge");
//
//        from("direct:deleteUser")
//                .to("jpa:remove");
    }
}

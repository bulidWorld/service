package org.zwx.restful.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/22.
 */
@Path("default")
public class StoreResource {

    /**
     * 简单测试RESTFUL服务
     * @return
     * @throws IOException
     */
    @Path("books")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String queryBook() throws IOException {
        return "dong ye gui wu";
    }

    /**
     * 测试Consumer注解
     * @return
     */
    @Path("plain/book")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String queryBookByHeader(){
        Map<String, String> map = new HashMap<>();
        map.put("a","东野");
        map.put("b","夏目");
        return "东野";
    }

    /**
     *测试路径名的正则表达式，否则返回没有资源
     * @Return String
     */
    @Path("test/regex/{order: [0-9]{5}}")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String testRegx(@PathParam("order") String order){

        return order + ":ok";
    }

}

package org.demo.prop;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@Controller
public class DescribeController {
    @RequestMapping("/describe")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "describe";
    }

    @RequestMapping("/say")
    @ResponseBody
    public String say(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("example.com").path("/hotels/{hotel}/bookings/{booking}").build()
                .expand("42", "21")
                .encode();

        model.addAttribute("name", name);
        return "saySomething";
    }

    @RequestMapping(path = "/handle", method = RequestMethod.POST)
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write("handleSomething");
    }

    @RequestMapping("/httpEntry")
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(path = "/callable")
    @ResponseBody
    public Callable<String> processUpload(final MultipartFile file) {
        return new Callable<String>() {
            public String call() throws Exception {
                return "someCallableView";
            }
        };
    }

    @RequestMapping("/deferredResult")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        // Save the deferredResult somewhere..
        deferredResult.setResult("deferredResultView");
        return deferredResult;
    }
}

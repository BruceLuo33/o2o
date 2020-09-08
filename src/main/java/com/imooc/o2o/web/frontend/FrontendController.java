package com.imooc.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FrontendController
 *
 * @author luoyi
 * @date 2020-09-2020/9/8 13:53
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index() {
        return "frontend/index";
    }

    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
    private String showShopDetail() {
        return "frontend/shopdetail";
    }

    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String shopProductDetail() {
        return "frontend/shopdetail";
    }

    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String showShopList() {
        return "frontend/shoplist";
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    private String index() {
//        return "frontend/index";
//    }
}

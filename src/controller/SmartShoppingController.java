package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.mysql.fabric.xmlrpc.base.Array;
import model.Items;
import org.apache.commons.logging.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dom4j.tree.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.DBHelper;

import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sheeban Raza on 27-Apr-16.
 */

@Controller
public class SmartShoppingController {

    @Autowired
    DBHelper dbHelper;

    @RequestMapping(value = "/jsonp.htm")
    public ModelAndView checkItems(@RequestParam(value = "jj", required = false) String json) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/second");
        ArrayList items = new Gson().fromJson(json, ArrayList.class);
        items = new ArrayList();
        items.add("S");
        ArrayList<Items> itemsArrayList = new ArrayList<Items>();
        if (items != null) {
            for (Object object : items) {
                Items searchedItem = dbHelper.findByName((String) object);
                itemsArrayList.add(searchedItem);
            }
        }
        Gson gson = new Gson();
        String jsonF = gson.toJson(itemsArrayList);
        modelAndView.addObject("jsonF", jsonF);
        return modelAndView;
    }


}

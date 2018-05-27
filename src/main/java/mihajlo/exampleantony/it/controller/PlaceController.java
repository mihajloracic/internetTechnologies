package mihajlo.exampleantony.it.controller;

import javassist.NotFoundException;
import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Place;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.service.MockDataService;
import mihajlo.exampleantony.it.service.StorageService;
import mihajlo.exampleantony.it.service.UserService;
import mihajlo.exampleantony.it.service.place.AdminPlaceService;
import mihajlo.exampleantony.it.service.place.SuperAdminPlaceService;
import mihajlo.exampleantony.it.service.place.UserPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    SuperAdminPlaceService superAdminPlaceService;

    @Autowired
    UserPlaceService userPlaceService;

    @Autowired
    MockDataService mockDataService;

    @Autowired
    UserService userService;

    @Autowired
    AdminPlaceService adminPlaceService;

    @Autowired
    StorageService storageService;

    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public void populate(){
        mockDataService.populateData();
    }

    @RequestMapping(value = "/place/all", method = RequestMethod.GET)
    public List<Place> getAllPlaces(){
        return userPlaceService.getAllPlaces();
    }
    @RequestMapping(value = "/place/city_type", method = RequestMethod.GET)
    public List<Place> getByCityAndType(@RequestParam("city") String city, @RequestParam("type") String type){
        return userPlaceService.getPlacesByCityAndType(city,type);
    }
    @RequestMapping(value = "/place/city", method = RequestMethod.GET)
    public List<Place> getByCity(@RequestParam("city") String city){
        return userPlaceService.getPlacesInCity(city);
    }

    @RequestMapping(value = "place/admin/add_image", method = RequestMethod.POST)
    public Place addImage(@RequestParam("file")MultipartFile file, @RequestParam Long id) throws NotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        Place place = userPlaceService.getPlaceById(id);
        place.setImage(storageService.store(file));
        return adminPlaceService.save(place,user);
    }

    @RequestMapping(value = "place/admin/add_place", method = RequestMethod.POST)
    public Place addPlace(@RequestBody Place place) throws NotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return adminPlaceService.save(place,user);
    }

    @RequestMapping(value = "place/byId",method = RequestMethod.GET)
    public Place getPlaceById(@RequestParam("id") Long id){
        Place place = userPlaceService.getPlaceById(id);
        return place;
    }

    @RequestMapping(value= "place/unapproved", method = RequestMethod.GET)
    public List<Place> getUnApprovedPlaces(){
        return superAdminPlaceService.getUnapprovedPlaces();
    }

    @RequestMapping(value = "place/approve", method = RequestMethod.POST)
    public Place approvePlace(@RequestBody Place place){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return superAdminPlaceService.approvePlace(place,user);
    }
    @RequestMapping(value = "place/delete", method = RequestMethod.POST)
    public Place deletePlace(@RequestBody Place place){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        superAdminPlaceService.deletePlace(place,user);
        return place;
    }
}

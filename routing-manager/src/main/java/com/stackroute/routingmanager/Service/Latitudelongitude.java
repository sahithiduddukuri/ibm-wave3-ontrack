package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Location;
import com.stackroute.routingmanager.Exceptions.IllegalLocationMatrixException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Latitudelongitude
{

    public String[] getDistanceMatrix(List<Location> locationList) {

        String[] endLocation = new String[2];
        System.out.println("Inside distance method");
        String url1 = "https://maps.googleapis.com/maps/api/directions/json?";
        String origins = "origins=";
        String origin = "";
        int count = 0;
        String destinations = "destinations=";
        String destination = "";
        String url2 = "key=AIzaSyAXigGROgiWO9fwGbXcOY09c6YHRZ8hPKo";
        String inline = "";
        //https://maps.googleapis.com/maps/api/directions/json?origin=Bangalore&destination=Pune&key=AIzaSyCS63yTeP52jSiVNCbt7fo_pdKmsT8Xjs4


            if (count < 1) {
                for (int i = 0; i < locationList.size(); i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.println("LocationList"+locationList.get(i).toString());
                        String str1 = locationList.get(0).getLocation();
                        System.out.println("Source loaction"+str1);
                        String str2 = locationList.get(1).getLocation();
                        origins ="origin=" +str1 ;
                        destinations ="destination="+  str2;

                    System.out.println("origins" + origins);
                    System.out.println("destinations" + destinations);


                    }
                }
                        origin = origins;
                        destination = destinations;

                System.out.println("origin" + origin);
                System.out.println("destination" + destination);
                String url = url1 + origin + "&" + destination + "&" + url2;
                url = url.replaceAll("\\s", "");
                System.out.println("URL = "+url);

                try {
                    count++;
                    URL url3 = new URL(url);
                    HttpsURLConnection conn = (HttpsURLConnection) url3.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();

                    int responsecode = conn.getResponseCode();
                    if (responsecode != 200)
                        throw new IllegalLocationMatrixException("HttpResponseCode: " + responsecode);
                    else {
                        Scanner sc = new Scanner(url3.openStream());
                        while (sc.hasNext()) {
                            inline += sc.nextLine();
                        }
                        sc.close();
                    }

                    JSONParser parse = new JSONParser();

                    JSONObject jobj = (JSONObject) parse.parse(inline);
                    System.out.println("Json output = "+jobj.get("routes"));
                    System.out.println("output from json is = "+ (JSONArray)jobj.get("routes"));


                    JSONArray J1= (JSONArray)jobj.get("routes");

                    String j2= J1.toString();
                    String [] j3 = j2.split("start_location");

                    String [] j4 = j3[1].split("}");



                  String startLocationCoordinates = j4[0].toString();

                //    System.out.println("Start loaction coordinates = "+startLocationCoordinates);
                    String [] j7 = startLocationCoordinates.split("lng");
                    String j9 = j7[1].toString();
                   // System.out.println("j9"+j9);
                    String [] j10 = j9.split(",");
                    String j11 = j10[0].toString();
                    String [] j12 = j11.split("\":");
                    String start_location_lng = j12[1].toString();
                  //  System.out.println("Start location : lat = " + start_location_lng);
                    String j15 = j10[1].toString();
                   // System.out.println("j15" + j15);
                    String [] j16 = j15.split("lat");
                    String j17 = j16[1].toString();
                   // System.out.println("j17" + j17);
                    String [] j18 = j17.split("\":");
                    String start_location_lat = j18[1].toString();
                 //   System.out.println("Start location : lat = "+start_location_lat);
                    String [] j5 = j2.split("end_location");

                   // System.out.println("wfdiufiuuuuuuuuuuuuiffiuf"+ j5[1].toString());


                    String [] j6 = j5[1].split("}");

                    String endLocationCoordinates = j6[0].toString();

                   // System.out.println("iuwdiugfwiuoihfweoiiiii"+endLocationCoordinates);

                    String [] j20 = startLocationCoordinates.split("lng");
                    String j21 = j20[1].toString();
                   // System.out.println("j21"+j21);
                    String [] j22 = j21.split(",");
                    String j23 = j22[0].toString();
                    String [] j29 = j23.split("\":");
                    String end_location_lng = j29[1].toString();
                    System.out.println("End location : lng = "+end_location_lng);
               //     System.out.println("j23" + j23);
                    String  j24 = j22[1].toString();
                 //   System.out.println("j24" + j24);
                    String [] j25 = j24.split("lat");
                    String j26 = j25[1].toString();
                  //  System.out.println("j26 "+ j26);
                    String [] j27 = j26.split("\":");
                    String end_location_lat = j27[1].toString();
                    System.out.println("End location: lat = "+end_location_lat);
                    endLocation[0] = end_location_lat;
                    endLocation[1] = end_location_lng;
                    conn.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        return endLocation;
    }
}

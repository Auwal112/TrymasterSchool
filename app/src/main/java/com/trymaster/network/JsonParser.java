package com.trymaster.network;
import org.json.*;
import com.trymaster.database.*;
public class JsonParser
{

		public static User parseUser(String jsonString){
			User user = new User();
			try {
				JSONArray array = new JSONArray(jsonString);
				JSONObject obj = array.getJSONObject(0);
				user.setId(obj.getInt("id"));
				user.setFullname(obj.getString("fullname"));
				user.setUsername(obj.getString("username"));
				user.setEmail(obj.getString("email"));
				user.setContact(obj.getString("contact"));
				//user.password = obj.getString("password");
			} catch (JSONException e){
				System.out.println(e);
			}
			return user;
		}
		
		
}

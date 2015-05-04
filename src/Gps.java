public class Gps {
	 public static final double R = 6372.8; // In kilometers

	public static void main(String[] args) {
		System.out.print("The distance between the two locations is " + (int)haversine(53.3807,-6.5945,40.689,-74.044) + " kilometres or " 
	+ (int)(haversine(53.3807,-6.5945,40.689,-74.044) * 0.621371) + " miles.");

	}
	
	   
	    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
	        double dLat = Math.toRadians(lat2 - lat1);
	        double dLon = Math.toRadians(lon2 - lon1);
	        lat1 = Math.toRadians(lat1);
	        lat2 = Math.toRadians(lat2);
	 
	        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
	        double c = 2 * Math.asin(Math.sqrt(a));
	        return R * c;
	    }
	   
	

}

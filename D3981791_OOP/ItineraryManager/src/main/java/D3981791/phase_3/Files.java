package D3981791.phase_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public static void SaveToFile(Itinerary itinerary){

        String filename = "file.ser";

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(itinerary);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }
}

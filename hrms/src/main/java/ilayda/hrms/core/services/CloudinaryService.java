package ilayda.hrms.core.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	
	Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();
		
		public CloudinaryService() {
			valuesMap.put("cloud_name","ilayda-ez" );
			valuesMap.put("api_key", "825653126933898" );
			valuesMap.put("api_secret","nUklcPBQaZZsvVdX7szOuBQKlO8" );
			cloudinary = new Cloudinary(valuesMap);
		}
		
		public Map upload(MultipartFile multipartFile) throws IOException {
			File file = convert(multipartFile);
			Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return result;
		}

		public Map delete(String id) throws IOException {
			Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
			return result;
		}

		private File convert(MultipartFile multipartFile) throws IOException {
			File file = new File(multipartFile.getOriginalFilename());
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(multipartFile.getBytes());
			fileOutputStream.close();
			return file;
		}
		

}

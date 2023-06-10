package fesenko.pictures.controller;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fesenko.pictures.Dto.ColorInfo;
import fesenko.pictures.Dto.PicturesInfoDto;

public class ColorPicturesAppl {

	static RestTemplate restTemplate = new RestTemplate();
	static final String BASE_URL = "https://api.imagga.com/v2/colors?image_url=";
	static final String API_KEY = "Basic YWNjXzYyYTU3ZGYzNzU3MWFmYjphNzA4YmY2MWE0NjNmZmM4MmZiMmY1ZDQ3ZTYwYTI4MQ==";
	static final String BASE_IMAGE_URL = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";

	public static void main(String[] args) {

		ResponseEntity<PicturesInfoDto> picturesInfo = restTemplate.exchange(
				RequestEntity.get(BASE_URL + BASE_IMAGE_URL).header("Authorization", API_KEY).build(),
				PicturesInfoDto.class);

		List<ColorInfo> imageColors = picturesInfo.getBody().getResult().getColors().getImage_colors();
		System.out.println("Image colors");
		imageColors.forEach(color -> {
			System.out.println("------------------------");
			System.out.println("Color Name: " + color.getClosest_palette_color());
			System.out.println("Color Perrent Name: " + color.getClosest_palette_color_parent());
			System.out.println("Color Percent: " + color.getPercent());
		});
		System.out.println("------------------------");
		List<ColorInfo> backgroundColors = picturesInfo.getBody().getResult().getColors().getBackground_colors();
		System.out.println("Background colors");
		backgroundColors.forEach(b_color -> {
		System.out.println("------------------------");
		System.out.println("Background Name: " + b_color.getClosest_palette_color() );
		System.out.println("Background Perrent Name: " + b_color.getClosest_palette_color_parent());
		System.out.println("Background Percent: " + b_color.getPercent() );
		});
	}

}

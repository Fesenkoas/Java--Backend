package fesenko.pictures.Dto;

import lombok.Getter;

@Getter
public class ColorInfo {
	int b;
	String closest_palette_color;
	String closest_palette_color_html_code;
	String closest_palette_color_parent;
	float closest_palette_distance;
	int g;
	String html_code;
	float percent;
	int r;
}

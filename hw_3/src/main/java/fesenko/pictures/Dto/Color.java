package fesenko.pictures.Dto;

import java.util.List;

import lombok.Getter;

@Getter
public class Color {
	List<ColorInfo> background_colors;
	float color_percent_threshold;
	float color_variance;
	List<ColorInfo> foreground_colors;
	List<ColorInfo> image_colors;
	float object_percentage;
}

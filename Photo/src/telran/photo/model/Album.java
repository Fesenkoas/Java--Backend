package telran.photo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Album {
	boolean addPhoto(Photo photo);

	boolean removePhoto(int photoId, int albumId);

	boolean updatePhoto(int photoId, int albumId, String url);

	Photo getPhotoFromAlbum(int photoId, int albumId);

	Photo[] getAllPhotoFromAlbum(int albumId);

	Photo[] getPhotoBeetwenDate(LocalDate dataFrom, LocalDate dataTo);

	int size();

}

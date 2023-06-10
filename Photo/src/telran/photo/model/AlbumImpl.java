package telran.photo.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class AlbumImpl implements Album {
	private Photo[] photos;
	private int size;
	Comparator<Photo> comparator;
	
	public AlbumImpl(int capacity) {
		photos = new Photo[capacity];
	}

	@Override
	public boolean addPhoto(Photo photo) {

		if (size == photos.length || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlumId()) != null) {
			return false;
		}
		photos[size++] = photo;
		return true;
	}

	@Override
	public boolean removePhoto(int photoId, int albumId) {
		Photo res = getPhotoFromAlbum(photoId, albumId);
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (photos[i].getAlumId() == albumId && photos[i].getPhotoId() == photoId) {
				index++;
			}
		}
		if (res != null && size >= 0) {
			System.arraycopy(photos, index + 1, photos, index, photos.length - 1);
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePhoto(int photoId, int albumId, String url) {
		Photo res = getPhotoFromAlbum(photoId, albumId);
		if (res != null) {
			res.setUrl(url);
			return true;
		}
		return false;
	}

	@Override
	public Photo getPhotoFromAlbum(int photoId, int albumId) {
		for (int i = 0; i < size; i++) {
			if (photos[i].getAlumId() == albumId && photos[i].getPhotoId() == photoId) {
				return photos[i];
			}
		}
		return null;
	}

	@Override
	public Photo[] getAllPhotoFromAlbum(int albumId) {
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (photos[i].getAlumId() == albumId) {
				index++;
			}
		}
		Photo[] res = new Photo[index];
		for (int i = 0, y = 0; i < size; i++) {
			if (photos[i].getAlumId() == albumId) {
				res[y++] = photos[i];
			}
		}
		return res;
	}

	@Override
	public Photo[] getPhotoBeetwenDate(LocalDate dateFrom, LocalDate dateTo) {
		int index = 0;

		for (int i = 0; i < size; i++) {
			LocalDate dt = photos[i].getData().toLocalDate();
			if ( dt.isAfter(dateFrom)&&dt.isBefore(dateTo)) {
				index++;
			}
		}
		Photo[] res = new Photo[index];
		for (int i = 0, y = 0; i < size; i++) {
			LocalDate dt = photos[i].getData().toLocalDate();
			if (dt.isAfter(dateFrom)&&dt.isBefore(dateTo)) {
				res[y++] = photos[i];
			}
		}
		return res;
	}

	@Override
	public int size() {
		return size;
	}

}

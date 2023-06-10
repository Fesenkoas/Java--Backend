package telran.album.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Predicate;

public class AlbumImpl implements Album {

	private Photo[] photos;
	private int size;

	public AlbumImpl(int capacity) {
		photos = new Photo[capacity];
	}

	@Override
	public boolean addPhoto(Photo photo) {
		if (size == photos.length || photo == null
				|| getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
			return false;
		}
		int index = Arrays.binarySearch(photos,0, size, photo);
		index = index >= 0 ? index : -index - 1;
		System.arraycopy(photos, index, photos, index + 1, size - index);
		photos[index] = photo;
		size++;
		
		return true;
	}

	@Override
	public boolean removePhoto(int photoId, int albumId) {
		Photo pattern = new Photo(albumId, photoId, null, null, null);
		for (int i = 0; i < size; i++) {
			if (photos[i].equals(pattern)) {
				photos[i] = photos[--size];
				photos[size] = null;
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean updatePhoto(int photoId, int albumId, String url) {
		Photo photo = getPhotoFromAlbum(photoId, albumId);
		if (photo == null) {
			return false;
		}
		photo.setUrl(url);
		return true;
	}

	@Override
	public Photo getPhotoFromAlbum(int photoId, int albumId) {
		for (int i = 0; i < size; i++) {
			if (photos[i].getAlbumId() == albumId && photos[i].getPhotoId() == photoId) {
				return photos[i];
			}
		}
		return null;
	}

	@Override
	public Photo[] getAllPhotoFromAlbum(int albumId) {
		return findByPredicate(p -> p.getAlbumId() == albumId);
	}

	@Override
	public Photo[] getPhotoBeetwenDate(LocalDate dateFrom, LocalDate dateTo) {
		Photo patern = new Photo(0,Integer.MIN_VALUE,null,null,dateFrom.atStartOfDay());
		int from = Arrays.binarySearch(photos,0, size,patern) -1;
		patern = new Photo(0,Integer.MAX_VALUE,null,null,LocalDateTime.of(dateTo, LocalTime.MAX));
		int to = Arrays.binarySearch(photos,0, size,patern)-1;
//		from = from>=0?from:-from-1;
//		to = to>=0? to:-to-1;
		
		return Arrays.copyOfRange(photos, from, to);
	}

	@Override
	public int size() {
		return size;
	}

	private Photo[] findByPredicate(Predicate<Photo> predicate) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(photos[i])) {
				count++;
			}
		}
		Photo[] res = new Photo[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(photos[i])) {
				res[j++] = photos[i];
			}
		}
		return res;
	}

}

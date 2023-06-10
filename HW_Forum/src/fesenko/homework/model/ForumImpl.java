package fesenko.homework.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class ForumImpl implements Forum {
	private Post[] posts;
	private int size;

	public ForumImpl() {
		this.posts = new Post[0];
	}

	@Override
	public boolean addPost(Post post) {

		if (post == null || getPostById(post.getPostId()) != null) {
			return false;
		}
		int index = Arrays.binarySearch(posts,0, size, post);
		index = index >= 0 ? index : -index-1;
		this.posts = Arrays.copyOf(posts, size + 1);
		System.arraycopy(posts, index, posts, index+1, size - index);
		posts[index] = post;
		size++;
		
//		this.posts = Arrays.copyOf(posts, size + 1);
//		this.posts[size++] = post;

		return true;
	}

	@Override
	public boolean removePost(int postId) {
		Post pattern = new Post(null, postId, null, null);
		for (int i = 0; i < size; i++) {
			if (posts[i].equals(pattern)) {
				posts[i] = posts[--size];
				posts[size] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePost(int postId, String newContent) {
		Post post = getPostById(postId);
		if (post == null) {
			return false;
		}
		post.setContent(newContent);
		return true;
	}

	@Override
	public Post getPostById(int postId) {
		for (int i = 0; i < size; i++) {
			if (posts[i].getPostId() == postId) {
				return posts[i];
			}
		}
		return null;
	}

	@Override
	public Post[] getPostByAuthor(String author) {

		return findByPredicate(p -> p.getAutor() == author);
	}

	@Override
	public Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
		Post[] actual = getPostByAuthor(author) ;
		int index = 0;
		for (int i = 0; i < actual.length; i++) {
			LocalDate dt = actual[i].getDate().toLocalDate();
			
			if ( dt.isAfter(dateFrom)&&dt.isBefore(dateTo)) {
				index++;
			}
		}
		Post[] res = new Post[index];
		for (int i = 0, y = 0; i < actual.length; i++) {
			LocalDate dt = actual[i].getDate().toLocalDate();
			if (dt.isAfter(dateFrom)&&dt.isBefore(dateTo)) {
				res[y++] = actual[i];
			}
		}
		return res;
	}

	@Override
	public int size() {
		return size;
	}

	private Post[] findByPredicate(Predicate<Post> predicate) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(posts[i])) {
				count++;
			}
		}
		Post[] res = new Post[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(posts[i])) {
				res[j++] = posts[i];
			}
		}
		return res;
	}

}

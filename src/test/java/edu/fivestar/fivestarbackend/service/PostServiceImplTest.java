//import edu.fivestar.fivestarbackend.domain.Post;
//import edu.fivestar.fivestarbackend.domain.User;
//import edu.fivestar.fivestarbackend.dto.PostCreateReqDto;
//import edu.fivestar.fivestarbackend.dto.PostUpdateReqDto;
//import edu.fivestar.fivestarbackend.dto.UserPostGetResDto;
//import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
//import edu.fivestar.fivestarbackend.repository.PostRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Pageable;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class PostServiceImplTest {
//
//
//    UserSignupReqDto Udto = new UserSignupReqDto("email@example","nameExample","passwordExample");
//
//
//    @Mock
//    private PostRepository postRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//
//    }
//
//    @Test
//    public void testCreatePost() {
//        // Arrange
//        User loginUser = new User(Udto);
//        PostCreateReqDto dto = new PostCreateReqDto("Title", "Content");
//
//        // Act
//        postService.createPost(loginUser, dto);
//
//        // Assert
//        verify(postRepository, times(1)).save(any(Post.class));
//    }
//
//    @Test
//    public void testGetPost_ValidPostId() {
//        // Arrange
//        Long postId = 1L;
//        Post post = new Post();
//        post.setId(postId);
//        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
//
//        // Act
//        UserPostGetResDto result = postService.getPost(postId);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(postId, result.getPostId());
//        verify(postRepository, times(1)).findById(postId);
//    }
//
//    @Test
//    public void testGetPost_InvalidPostId() {
//        // Arrange
//        Long postId = 1L;
//        when(postRepository.findById(postId)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> postService.getPost(postId));
//        verify(postRepository, times(1)).findById(postId);
//    }
//
//    @Test
//    public void testGetPostsByUser() {
//        // Arrange
//        User loginUser = new User();
//        Pageable pageable = Pageable.ofSize(10);
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post());
//        when(postRepository.findPostsByUser(loginUser, pageable)).thenReturn(posts);
//
//        // Act
//        List<UserPostGetResDto> result = postService.getPostsByUser(loginUser, pageable);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(posts.size(), result.size());
//        verify(postRepository, times(1)).findPostsByUser(loginUser, pageable);
//    }
//
//    @Test
//    public void testUpdatePost_ValidPost() {
//        // Arrange
//        User loginUser = new User();
//        Long postId = 1L;
//        PostUpdateReqDto dto = new PostUpdateReqDto("Updated Title", "Updated Content");
//        Post post = new Post();
//        post.setId(postId);
//        when(postRepository.findPostByUserAndId(loginUser, postId)).thenReturn(Optional.of(post));
//
//        // Act
//        postService.updatePost(loginUser, postId, dto);
//
//        // Assert
//        verify(postRepository, times(1)).findPostByUserAndId(loginUser, postId);
//        assertEquals(dto.getTitle(), post.getTitle());
//        assertEquals(dto.getContent(), post.getContent());
//    }
//
//    @Test
//    public void testUpdatePost_InvalidPost() {
//        // Arrange
//        User loginUser = new User();
//        Long postId = 1L;
//        PostUpdateReqDto dto = new PostUpdateReqDto("Updated Title", "Updated Content");
//        when(postRepository.findPostByUserAndId(loginUser, postId)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> postService.updatePost(loginUser, postId, dto));
//        verify(postRepository, times(1)).findPostByUserAndId(loginUser, postId);
//    }
//
//    @Test
//    public void testDeletePost_ValidPost() {
//        // Arrange
//        User loginUser = new User();
//        Long postId = 1L;
//        Post post = new Post();
//        post.setId(postId);
//        when(postRepository.findPostByUserAndId(loginUser, postId)).thenReturn(Optional.of(post));
//
//        // Act
//        postService.deletePost(loginUser, postId);
//
//        // Assert
//        verify(postRepository, times(1)).findPostByUserAndId(loginUser, postId);
//        verify(postRepository, times(1)).delete(post);
//    }
//
//    @Test
//    public void testDeletePost_InvalidPost() {
//        // Arrange
//        User loginUser = new User();
//        Long postId = 1L;
//        when(postRepository.findPostByUserAndId(loginUser, postId)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> postService.deletePost(loginUser, postId));
//        verify(postRepository, times(1)).findPostByUserAndId(loginUser, postId);
//    }
//}
// Test generated by RoostGPT for test knote-java using AI Type Open AI and AI Model gpt-4

package alahyaoui.curriculum.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import alahyaoui.curriculum.model.Course;
import alahyaoui.curriculum.repository.CourseRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseService_getCoursesBy_a84b36031a_Test {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    private Course course1;
    private Course course2;

    @BeforeEach
    public void setup() {
        course1 = new Course();
        course1.setId("CS101");
        course1.setTitle("Intro to CS");

        course2 = new Course();
        course2.setId("CS102");
        course2.setTitle("Data Structures");

        when(courseRepository.findByIdContaining("CS101")).thenReturn(Arrays.asList(course1));
        when(courseRepository.findByTitleContaining("Intro to CS")).thenReturn(Arrays.asList(course1));
        when(courseRepository.findAllByOrderByQuarterAscIdAsc()).thenReturn(Arrays.asList(course1, course2));
    }

    @Test
    public void testGetCoursesById() {
        List<Course> result = courseService.getCoursesBy("id", "CS101");
        assertEquals(1, result.size());
        assertEquals(course1, result.get(0));
    }

    @Test
    public void testGetCoursesByTitle() {
        List<Course> result = courseService.getCoursesBy("title", "Intro to CS");
        assertEquals(1, result.size());
        assertEquals(course1, result.get(0));
    }

    @Test
    public void testGetCoursesByDefault() {
        List<Course> result = courseService.getCoursesBy(null, null);
        assertEquals(2, result.size());
        assertEquals(course1, result.get(0));
        assertEquals(course2, result.get(1));
    }
}

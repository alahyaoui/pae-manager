// Test generated by RoostGPT for test knote-java using AI Type Open AI and AI Model gpt-4

package alahyaoui.curriculum.business;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Component;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Component
public class CourseGraph_search_fd8423eeca_Test {

    @InjectMocks
    private CourseGraph courseGraph;

    @Mock
    private Set<CourseNode> nodes;

    @Mock
    private Iterator<CourseNode> iterator;

    @Mock
    private CourseNode node;

    @Before
    public void setUp() {
        when(nodes.iterator()).thenReturn(iterator);
    }

    @Test
    public void testSearch_NodeFound() {
        String id = "testId";
        when(iterator.hasNext()).thenReturn(true, false);
        when(iterator.next()).thenReturn(node);
        when(node.getId()).thenReturn(id);

        CourseNode result = courseGraph.search(id);

        assertEquals(node, result);
    }

    @Test
    public void testSearch_NodeNotFound() {
        String id = "testId";
        when(iterator.hasNext()).thenReturn(true, false);
        when(iterator.next()).thenReturn(node);
        when(node.getId()).thenReturn("differentId");

        CourseNode result = courseGraph.search(id);

        assertNull(result);
    }
}

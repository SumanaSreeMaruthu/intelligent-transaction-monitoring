package dev.sumana.portfolio.notes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class RecordNoteServiceTest {
    @Mock RecordNoteRepository repository;
    @InjectMocks RecordNoteService service;

    @Test
    void returnsNotesForOwner() {
        when(repository.findByResourceTypeAndResourceIdOrderByCreatedAtDesc("case", 1L))
                .thenReturn(List.of());
        assertTrue(service.list("case", 1L).isEmpty());
    }

    @Test
    void rejectsEmptyBody() {
        assertThrows(ResponseStatusException.class, () -> service.add("case", 1L, " "));
        verifyNoInteractions(repository);
    }

    @Test
    void rejectsInvalidOwner() {
        assertThrows(ResponseStatusException.class, () -> service.list("../", 1L));
    }
}

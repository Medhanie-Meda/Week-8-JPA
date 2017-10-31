package businesslogic;

import dataaccess.NoteDB;
import domainmodel.Note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NoteService {

    private NoteDB userDB;

    public NoteService() {
        userDB = new NoteDB();
    }

    public Note get(int noteId) throws Exception {
        return userDB.getNote(noteId);
    }

    public List<Note> getAll() throws Exception {
        return userDB.getAll();
    }

    public int update(int noteId, String contents) throws Exception {
        Note note = new Note(noteId, contents);
        return userDB.update(note);
    }

    public int delete(int noteId) throws Exception {
        Note deletedNote = userDB.getNote(noteId);
        return userDB.delete(deletedNote);
    }

    public int insert(String contents) throws Exception {
        Note note = new Note(contents);
        java.util.Date uDate = new java.util.Date();  
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        note.setDateCreated(sDate);
        return userDB.insert(note);
    }       
}

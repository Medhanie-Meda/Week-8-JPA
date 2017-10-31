package businesslogic;

import dataaccess.NoteDB;
import domainmodel.Note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NoteService {

    private NoteDB noteDB;

    public NoteService() {
        noteDB = new NoteDB();
    }

    public Note get(int noteId) throws Exception {
        return noteDB.getNote(noteId);
    }

    public List<Note> getAll() throws Exception {
        return noteDB.getAll();
    }

    public int update(int noteId, String contents) throws Exception {
        Note note = noteDB.getNote(noteId);
        note.setContents(contents);    
        return noteDB.update(note);
    }

    public int delete(int noteId) throws Exception {
        Note deletedNote = noteDB.getNote(noteId);
        return noteDB.delete(deletedNote);
    }

    public int insert(String contents) throws Exception {
        
        java.util.Date uDate = new java.util.Date();  
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        Note note = new Note(0, sDate, contents);
        //note.setDateCreated(sDate);
        return noteDB.insert(note);
    }       
}

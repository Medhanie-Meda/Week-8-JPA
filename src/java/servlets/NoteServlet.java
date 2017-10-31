package servlets;

import businesslogic.NoteService;
import domainmodel.Note;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService us = new NoteService();
        String action = request.getParameter("action");
        
        if (action != null && action.equals("view")) {
            String selectedId = request.getParameter("selectedId");
            try {
                Note note = us.get(Integer.parseInt(selectedId));
                request.setAttribute("selectedNote", note);
            } catch (Exception ex) {
                Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //I am here...
        
        ArrayList<Note> notes = null;        
        try {
            notes = (ArrayList<Note>) us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        //String createdDate = request.getParameter("createddate");
        if(action==null) action="";

        NoteService ns = new NoteService();

        try {
            if (action.equals("delete")) {
                //It will complain of I assign the variable
                int selectedId = Integer.parseInt(request.getParameter("selectedId"));
                ns.delete(selectedId);
            } else if (action.equals("edit")) {
                int noteId = Integer.parseInt(request.getParameter("noteid"));
                String contents = request.getParameter("contents");
                ns.update(noteId, contents);
            } else if (action.equals("add")) {
                String contents = request.getParameter("contents");
                ns.insert(contents);
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Whoops.  Could not perform that action.");
        }
        
        ArrayList<Note> notes = null;
        try {
            notes = (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
}

package ru.job4j.javaio;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Servertest {

    @Test
    public void whenexitchat() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayInputStream in = new ByteArrayInputStream("пока".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.startserv();
        assertThat(out.toString(), is(""));

    }
    @Test
    public void whenprinthello() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayInputStream in = new ByteArrayInputStream(
                String.format("hello%sпока", System.lineSeparator()).getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.startserv();
        assertThat(out.toString(), is("Hello, dear friend, I'm a oracle.\r\n"));

    }
    @Test
    public void whenoraclenotunderstand() throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayInputStream in = new ByteArrayInputStream(
                String.format("anyway%sпока", System.lineSeparator()).getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.startserv();
        assertThat(out.toString(), is("not understand\r\n"));

    }
}

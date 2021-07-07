/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import App.Middleware.MiddlewareAuth;
import App.Network.NetworkPool;

import Controller.AuthController;

import View.User.UserIndex;
import View.Admin.AdminIndex;

import Tools.Colorful;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author Fajar-PC
 */
public class SinglePage extends javax.swing.JFrame {

    /**
     * Creates new form SinglePage
     */
    protected NetworkPool np = new NetworkPool();
    private MiddlewareAuth mwAuth = new MiddlewareAuth();
    private final Colorful c = new Colorful();
    private final AdminIndex admIndex = new AdminIndex();
    private final UserIndex usrIndex = new UserIndex();

    public SinglePage() {
        initComponents();
        SPA();
        getNetworkPool().getConnMan().defaultUrl();
    }
    
    public void logConnManConnStmRs() {
        System.out.println("URL: "+getNetworkPool().getConnMan().getUrl());
        System.out.println("Connman: "+getNetworkPool().getConnMan()+"\nConn: "+getNetworkPool().getConnMan().logOn());
    }
    
    public void verification() {
        String[] boilerplate = new AuthController().boilerplate();
        System.out.println("length slices: "+boilerplate.length);
        boolean found = false;
        for (int i = 0; i <= boilerplate.length-1; i+=3) {
            System.out.println("boilerplate[i]"+boilerplate[i]);
            if (("admin".equals(txt_username.getText())) && ("admin".equals(txt_password.getText())) && ((txt_username.getText() == null ? boilerplate[i+1] == null : txt_username.getText().equals(boilerplate[i+1])) && (txt_password.getText() == null ? boilerplate[i+2] == null : txt_password.getText().equals(boilerplate[i+2])))) {
                found = true;
                getMiddlewareAuth().setAuthKey(boilerplate[i]);
                getMiddlewareAuth().setUsername(boilerplate[i+1]);
                getMiddlewareAuth().setPassword(boilerplate[i+2]);
                JOptionPane.showMessageDialog(null, "Logged in!", "200 OK", 1); setAndGotoAdminIndex(); HideThis(); break;
            }
            if ((txt_username.getText() == null ? boilerplate[i+1] == null : txt_username.getText().equals(boilerplate[i+1])) && (txt_password.getText() == null ? boilerplate[i+2] == null : txt_password.getText().equals(boilerplate[i+2]))) {
                found = true;
                getMiddlewareAuth().setAuthKey(boilerplate[i]);
                getMiddlewareAuth().setUsername(boilerplate[i+1]);
                getMiddlewareAuth().setPassword(boilerplate[i+2]);
                JOptionPane.showMessageDialog(null, "Logged in!", "200 OK", 1); setAndGotoUserIndex(); HideThis(); break;
            }
            if ((!found) && (i == boilerplate.length-1)) { JOptionPane.showMessageDialog(null, "Login invalid!"); }
        }
    }
    
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    
    public void setMiddlewareAuth(MiddlewareAuth val) { this.mwAuth = val; }
    public MiddlewareAuth getMiddlewareAuth() { return this.mwAuth; }
    
    public void logMiddlewareAuth() {
        JOptionPane.showMessageDialog(null, "Auth-Key: "+getMiddlewareAuth().getAuthKey()+"Username: "+getMiddlewareAuth().getUsername()+"Password: "+getMiddlewareAuth().getPassword());
    }
    
    public void setAndGotoAdminIndex() {
        getAdminIndex().setMiddlewareAuth(getMiddlewareAuth());
        getAdminIndex().setNotifierHtml("<html><h1>Welcome, "+txt_username.getText()+"</h1></html>");
        getAdminIndex().setNetworkPool(getNetworkPool());
        getAdminIndex().logMiddlewareAuth();
        getAdminIndex().setVisible(true);
    }
    
    public void setAndGotoUserIndex() {
        getUserIndex().setMiddlewareAuth(getMiddlewareAuth());
        getUserIndex().setNotifierToHtml("<html><h1>Welcome, "+txt_username.getText()+"</h1></html>");
        getUserIndex().setNetworkPool(getNetworkPool());
        getUserIndex().logMiddlewareAuth();
        getUserIndex().setVisible(true);
    }
    
    public AdminIndex getAdminIndex() { return admIndex; }
    public UserIndex getUserIndex() { return usrIndex; }
    
    public void HideThis() {
        this.setVisible(false);
    }
    
    // System
    public void HidePanelSystem() {
        panel_system.setVisible(false);
    }
    
    public void ShowPanelSystem() {
        panel_system.setVisible(true);
    }
    
    // Content
    public void HidePanelContent() {
        panel_content.setVisible(false);
    }
    
    public void ShowPanelContent() {
        panel_content.setVisible(true);
    }
    
    // Notifier
    public void HideNotifier() {
        panel_notifier.setVisible(false);
    }
    
    public void ShowNotifier() {
        panel_notifier.setVisible(true);
    }
    
    // Note To Notifier
    public void NoteToNotifier(String val) {
        txt_notifier.setText(val);
    }
    
    // Navbar Active/Inactive
    public void ActiveInactiveNavbar(Color home, Color about, Color contact, Color faq) {
        nav_home.setForeground(home);
        nav_about.setForeground(about);
        nav_contact.setForeground(contact);
        nav_faq.setForeground(faq);
    }
    
    public void ActiveInactiveBackground(Color nav, Color notif, Color sys, Color content) {
        panel_nav.setBackground(nav);
        panel_notifier.setBackground(notif);
        panel_system.setBackground(sys);
        panel_content.setBackground(content);
    }
    
    public void ActivaInactiveBackgroundNavbar(Color home, Color about, Color contact, Color faq) {
        nav_home.setBackground(home);
        nav_about.setBackground(about);
        nav_contact.setBackground(contact);
        nav_faq.setBackground(faq);
    }
    
    public void ChangeBtnLoginRegister(String val) {
        btn_loginregister.setText(val);
    }
    
    public void setHeaderHtml(String val) {
        lbl_header.setText(val);
    }
    
    public void setSectionHtml(String val) {
        lbl_section.setText(val);
    }
    
    public void setFooterHtml(String val) {
        lbl_footer.setText(val);
    }
    
    public void setNotifierHtml(String val) {
        NoteToNotifier(val);
    }
    
    public void setSystemHtml(String val) {
        NoteToSystem(val);
    }
    
    public void NoteToSystem(String val) {
        txt_system.setText(val);
    }
    
    // Starter App
    public void SPA() {
        HidePanelContent();
        ActiveInactiveBackground(c.getBlueCommonBright(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        setNotifierHtml("<html><h1>Warehouse of Book  </h1></html>");
        setSystemHtml("<html><h3>System Login</h3></html>");
        logConnManConnStmRs();
    }
    
    // Navbar Home
    public void NavHome(java.awt.event.MouseEvent evt) {
        txt_notifier.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_warehouse_32px.png")));
        ActivaInactiveBackgroundNavbar(c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveBackground(c.getBlueCommonBright(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveNavbar(c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        ChangeBtnLoginRegister("Login");
        setSystemHtml("<html><h3>System Login</h3></html>");
//        NoteToNotifier("Home  ");
        setNotifierHtml("<html><h1>Warehouse of Book  </h1></html>");
        ShowPanelSystem();
        HidePanelContent();
    }
    
    // Navbar About
    public void NavAbout(java.awt.event.MouseEvent evt) {
        txt_notifier.setIcon(null);
        ActivaInactiveBackgroundNavbar(c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveBackground(c.getBlueCommonBright(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveNavbar(c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor());
        HidePanelSystem();
//        NoteToNotifier("About");
        setNotifierHtml("<html><h1>About  </h1></html>");
        setHeaderHtml("<html><h1>About Page</h1></html>");
        setSectionHtml("<html><p>Bookkeeping your list of books that can makes you</p><p>easily manage just like real warehouse of library with many books</p></html>");
        setFooterHtml("");
        panel_content.setVisible(true);
    }
    
    // Navbar Contact
    public void NavContact(java.awt.event.MouseEvent evt) {
        txt_notifier.setIcon(null);
        ActivaInactiveBackgroundNavbar(c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon());
        ActiveInactiveBackground(c.getBlueCommonBright(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveNavbar(c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor());
        HidePanelSystem();
//        NoteToNotifier("Contact");
        setNotifierHtml("<html><h1>Contact  </h1></html>");
        setHeaderHtml("<html><h1>Contact Page</h1></html>");
        setSectionHtml("<html><p>Contact to official : <strong>022-5223413</strong></p><p>Thank you..</p></html>");
        setFooterHtml("");
        panel_content.setVisible(true);
    }
    
    // Navbar FAQ
    public void NavFAQ(java.awt.event.MouseEvent evt) {
        txt_notifier.setIcon(null);
        ActivaInactiveBackgroundNavbar(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor());
        ActiveInactiveBackground(c.getBlueCommonBright(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        ActiveInactiveNavbar(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor());
        HidePanelSystem();
//        NoteToNotifier("FAQ");
        setNotifierHtml("<html><h1>FAQ  </h1></html>");
        setHeaderHtml("<html><h1>FAQ Page</h1></html>");
        setSectionHtml("<html><p>FAQ ?</p><p>Check <strong>\"Check Contact Page\"</strong></p></html>");
        setFooterHtml("");
        panel_content.setVisible(true);
    }
    
    public void checkAndDoWithBtnTextSystem() {
        String btnText = btn_loginregister.getText();
        
        if ("Login".equals(btnText)) {
            verification();
//            boilerplate();
//            if (("admin".equals(username)) && ("admin".equals(password))) { JOptionPane.showMessageDialog(null, "Logged in!"); setAndGotoAdminIndex(); HideThis();  }
//            if (("user".equals(username)) && ("user".equals(password))) { JOptionPane.showMessageDialog(null, "Logged in!"); setAndGotoUserIndex(); HideThis();  }
        }
        if ("Register".equals(btnText)) {
            String query = "insert into auth (id_auth, username_auth, password_auth) values ('"+"ID-"+txt_username.getText()+"', '"+txt_username.getText()+"', '"+txt_password.getText()+"')";
            AuthController auth = new AuthController();
            auth.setOp("C");
            auth.setNetworkPool(getNetworkPool());
            auth.setQuery(query);
            auth.Create();
            JOptionPane.showMessageDialog(null, "Query "+query);
            JOptionPane.showMessageDialog(null, "Registered!");
        }
    }
    
    public void HelpTouched(java.awt.event.MouseEvent evt) {
        if ("Login".equals(btn_loginregister.getText())) {
            setSystemHtml("<html><h3>System Register</h3></html>");
            ChangeBtnLoginRegister("Register");
            txt_help.setText("Login?");
            txt_help.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_login_32px.png")));
        } else {
        
        setSystemHtml("<html><h3>System Login</h3></html>");
        ChangeBtnLoginRegister("Login");
        txt_help.setText("Register?");
        txt_help.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_registration_32px.png")));}
    }
    
    public void LoginRegisterTouched(java.awt.event.MouseEvent evt) {
        System.out.println(txt_username.getText());
        System.out.println(txt_password.getText());
        checkAndDoWithBtnTextSystem();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel2 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        panel_nav = new javax.swing.JPanel();
        nav_home = new javax.swing.JLabel();
        nav_about = new javax.swing.JLabel();
        nav_contact = new javax.swing.JLabel();
        nav_faq = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        panel_notifier = new javax.swing.JPanel();
        txt_notifier = new javax.swing.JLabel();
        panel_system = new javax.swing.JPanel();
        txt_system = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_loginregister = new javax.swing.JButton();
        txt_help = new javax.swing.JLabel();
        panel_content = new javax.swing.JPanel();
        lbl_header = new javax.swing.JLabel();
        lbl_section = new javax.swing.JLabel();
        lbl_footer = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        jLabel2.setText("jLabel2");

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_nav.setBackground(new java.awt.Color(0, 153, 255));

        nav_home.setBackground(new java.awt.Color(70, 163, 255));
        nav_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_home.setForeground(new java.awt.Color(255, 255, 255));
        nav_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_home_32px_1.png"))); // NOI18N
        nav_home.setText("Home");
        nav_home.setOpaque(true);
        nav_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_homeMouseClicked(evt);
            }
        });

        nav_about.setBackground(new java.awt.Color(0, 153, 255));
        nav_about.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_about.setForeground(new java.awt.Color(255, 255, 255));
        nav_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_about_32px.png"))); // NOI18N
        nav_about.setText("About");
        nav_about.setOpaque(true);
        nav_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_aboutMouseClicked(evt);
            }
        });

        nav_contact.setBackground(new java.awt.Color(0, 153, 255));
        nav_contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_contact.setForeground(new java.awt.Color(255, 255, 255));
        nav_contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_contacts_32px_1.png"))); // NOI18N
        nav_contact.setText("Contact");
        nav_contact.setOpaque(true);
        nav_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_contactMouseClicked(evt);
            }
        });

        nav_faq.setBackground(new java.awt.Color(0, 153, 255));
        nav_faq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_faq.setForeground(new java.awt.Color(255, 255, 255));
        nav_faq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_faq_32px.png"))); // NOI18N
        nav_faq.setText("FAQ");
        nav_faq.setOpaque(true);
        nav_faq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_faqMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_navLayout = new javax.swing.GroupLayout(panel_nav);
        panel_nav.setLayout(panel_navLayout);
        panel_navLayout.setHorizontalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nav_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_about, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_contact, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(nav_faq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_navLayout.setVerticalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(nav_home)
                .addGap(26, 26, 26)
                .addComponent(nav_about)
                .addGap(26, 26, 26)
                .addComponent(nav_contact)
                .addGap(26, 26, 26)
                .addComponent(nav_faq))
        );

        panel_notifier.setBackground(new java.awt.Color(0, 153, 255));

        txt_notifier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_notifier.setForeground(new java.awt.Color(255, 255, 255));
        txt_notifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_warehouse_32px.png"))); // NOI18N
        txt_notifier.setText("Title  ");

        javax.swing.GroupLayout panel_notifierLayout = new javax.swing.GroupLayout(panel_notifier);
        panel_notifier.setLayout(panel_notifierLayout);
        panel_notifierLayout.setHorizontalGroup(
            panel_notifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_notifierLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(txt_notifier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_notifierLayout.setVerticalGroup(
            panel_notifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_notifierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_notifier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_system.setBackground(new java.awt.Color(0, 153, 255));

        txt_system.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_system.setForeground(new java.awt.Color(255, 255, 255));
        txt_system.setText("System Login");
        txt_system.setToolTipText("");

        lbl_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Username");

        lbl_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Password");

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_username.setText("admin");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_usernamePropertyChange(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password.setText("admin");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        btn_loginregister.setText("Login");
        btn_loginregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginregisterMouseClicked(evt);
            }
        });

        txt_help.setForeground(new java.awt.Color(255, 255, 255));
        txt_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_registration_32px.png"))); // NOI18N
        txt_help.setText("Register?");
        txt_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_helpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_systemLayout = new javax.swing.GroupLayout(panel_system);
        panel_system.setLayout(panel_systemLayout);
        panel_systemLayout.setHorizontalGroup(
            panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_systemLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addGroup(panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_loginregister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_systemLayout.createSequentialGroup()
                        .addGroup(panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_username)
                            .addComponent(lbl_password))
                        .addGap(18, 18, 18)
                        .addGroup(panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txt_password)))
                    .addComponent(txt_help)
                    .addComponent(txt_system, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panel_systemLayout.setVerticalGroup(
            panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_systemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txt_system)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_username)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_systemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_loginregister, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_help)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_content.setBackground(new java.awt.Color(0, 153, 255));

        lbl_header.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(255, 255, 255));
        lbl_header.setText("Header");

        lbl_section.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section.setText("Section");

        lbl_footer.setForeground(new java.awt.Color(255, 255, 255));
        lbl_footer.setText("Footer");

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_footer)
                        .addComponent(lbl_section)))
                .addGap(415, 415, 415))
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_header)
                .addGap(31, 31, 31)
                .addComponent(lbl_section)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_footer)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_notifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addComponent(panel_system, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addComponent(panel_notifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_system, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void nav_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_aboutMouseClicked
        // TODO add your handling code here:
        NavAbout(evt);
    }//GEN-LAST:event_nav_aboutMouseClicked

    private void nav_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_contactMouseClicked
        // TODO add your handling code here:
        NavContact(evt);
    }//GEN-LAST:event_nav_contactMouseClicked

    private void nav_faqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_faqMouseClicked
        // TODO add your handling code here:
        NavFAQ(evt);
    }//GEN-LAST:event_nav_faqMouseClicked

    private void nav_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_homeMouseClicked
        // TODO add your handling code here:
        NavHome(evt);
    }//GEN-LAST:event_nav_homeMouseClicked

    private void txt_helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_helpMouseClicked
        // TODO add your handling code here:
        HelpTouched(evt);
    }//GEN-LAST:event_txt_helpMouseClicked

    private void btn_loginregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginregisterMouseClicked
        // TODO add your handling code here:
        LoginRegisterTouched(evt);
    }//GEN-LAST:event_btn_loginregisterMouseClicked

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_usernamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernamePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SinglePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinglePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinglePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinglePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinglePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loginregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_section;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel nav_about;
    private javax.swing.JLabel nav_contact;
    private javax.swing.JLabel nav_faq;
    private javax.swing.JLabel nav_home;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_nav;
    private javax.swing.JPanel panel_notifier;
    private javax.swing.JPanel panel_system;
    private javax.swing.JLabel txt_help;
    private javax.swing.JLabel txt_notifier;
    private javax.swing.JTextField txt_password;
    private javax.swing.JLabel txt_system;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}

<?php  
 defined('BASEPATH') OR exit('No direct script access allowed');  
 class Dashboard extends CI_Controller {  

 	public function __construct()
	{
		parent::__construct();
		//Load Dependencies
	}

    function index(){  
           if($this->session->userdata('username') != '')  
           {  
                $this->load->view("dashboard/index.php");   
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }  
      } 
   
      function logout()  
      {  
           $this->session->unset_userdata('username');  
           redirect(base_url() . 'main/login');  
      }  
 }  

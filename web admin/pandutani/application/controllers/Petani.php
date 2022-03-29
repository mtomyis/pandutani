<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
* 
*/
class Petani extends CI_Controller
{
	
	function __construct()
	{
		parent::__construct();

		//load kelas petani_model ke controller Petani
		$this->load->model('petani_model');
		$this->load->helper('url');
	}

	public function index()
	{
		if($this->session->userdata('username') != '')  
           {  
				$data['data_petani'] = $this->petani_model->tampil_data();
				$this->load->view('petani/index', $data);
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
		
	}

	public function simpan()
	{
		if($this->session->userdata('username') != '')  
           {  
				$data['nama_petani'] = $this->input->post('nama_petani');
				$data['nama_belakang'] = $this->input->post('nama_belakang');
				$data['password_petani'] = $this->input->post('password_petani');
				$data['alamat'] = $this->input->post('alamat');
				$this->petani_model->input_data($data);
				redirect('petani');	
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}

	public function tambah()
	{
		if($this->session->userdata('username') != '')  
           {  
				$this->load->view('petani/tambah');
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}

	public function update()
	{
		if($this->session->userdata('username') != '')  
           {  
				$id_petani = $this->input->post('idpetani');
				$data['nama_petani'] = $this->input->post('nama_petani');
				$data['nama_belakang'] = $this->input->post('nama_belakang');
				$data['password_petani'] = $this->input->post('password_petani');
				$data['alamat'] = $this->input->post('alamat');

				$this->petani_model->update_data($data, $id_petani);
				redirect('petani');
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}
	public function edit($id)
	{
		if($this->session->userdata('username') != '')  
           {  
				$data['data'] = $this->petani_model->spesifik_Data($id);
				$this->load->view('petani/edit', $data);
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}

	public function hapus($id)
	{
		if($this->session->userdata('username') != '')  
           {
				$this->petani_model->hapus_data($id);
				//$this->load->view('petani/delete');
				redirect('petani');
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}


}
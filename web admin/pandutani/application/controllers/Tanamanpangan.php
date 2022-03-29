<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
* 
*/
class Tanamanpangan extends CI_Controller
{
	
	function __construct()
	{
		parent::__construct();

		//load kelas tanamanpangan_model ke controller Tanamanpangan
		$this->load->model('tanamanpangan_model');
        $this->load->helper('number');
		$this->load->helper(array('form', 'url'));
	}

	public function index()
	{
		if($this->session->userdata('username') != '')  
           {  
				$data['data_tanamanpangan'] = $this->tanamanpangan_model->tampil_data();
				$this->load->view('tanamanpangan/index', $data);
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
				if(isset($_POST['submit']))
				{
					$config['upload_path'] = './upload/';
		        	$config['allowed_types'] = 'gif|jpg|png';
		        	$config['max_size']	= '';
		        	$config['max_width']  = '';
		        	$config['max_height']  = '';

		            $this->load->library('upload', $config);
		            //$this->tanamanpangan->initialize($config);
		            if(!$this->upload->do_upload('gambar_tanaman'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		            	//$this->data['data_gambar'] = $this->upload->data();
		                $gambar=$this->upload->file_name;
		            }

		        //$gambar_tanaman = file_get_contents($_FILES['gambar_tanaman']['name']);
		  		//$image_name = mysql_real_escape_string($_FILES['gambar_tanaman']['name']);
				//$get_image = $this->input->post($gambar_tanaman);
				$data['nama_tanaman'] = $this->input->post('nama_tanaman');
				$data['uraian_tanaman'] = $this->input->post('uraian_tanaman');
				// $data['gambar_tanaman'] = $this->input->post('gambar_tanaman');

				
				// if (getimagesize($_FILES['gambar_tanaman']['tmp_name'])== false) {
				// 	echo "coba lagi";
				// }
				// else
				// {
				// 	$getdata= addslashes($_FILES['gambar_tanaman']['tmp_name']);
				// 	$getdataa= file_get_contents($getdata);
				// 	$getdataa= base64_encode($getdata);
				// }
				$data['gambar_tanaman'] = $gambar;

				
				// $get_image = $this->input->post(file_get_contents($_FILES['gambar_tanaman']['tmp_name']));

				//echo $image;
				// $this->m_upload->simpan($image_name,$image);

				// $get_image = $this->input->post(file_get_contents($_FILES['gambar_tanaman']['tmp_name'])); 
				
				// $gambar_tanaman = $_FILES['gambar_tanaman']['tmp_name'];
				// $data['gambar_tanaman'] = mysql_real_escape_string(file_get_contents($gambar_tanaman));
				$this->tanamanpangan_model->input_data($data);
				}
				redirect('tanamanpangan');
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
				$this->load->view('tanamanpangan/tambah');
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
				if(isset($_POST['submit']))
				{
					$config['upload_path'] = './upload/';
		        	$config['allowed_types'] = 'gif|jpg|png';
		        	$config['max_size']	= '';
		        	$config['max_width']  = '';
		        	$config['max_height']  = '';

		            $this->load->library('upload', $config);
		            if(!$this->upload->do_upload('gambar_tanaman'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		                $gambar=$this->upload->file_name;
		            }
				$id_tanamanpangan = $this->input->post('idtanaman_pangan');
				$data['nama_tanaman'] = $this->input->post('nama_tanaman');
				$data['uraian_tanaman'] = $this->input->post('uraian_tanaman');
				$data['gambar_tanaman'] = $gambar;
				

				$this->tanamanpangan_model->update_data($data, $id_tanamanpangan);
				}
				redirect('tanamanpangan');
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
				$data['data'] = $this->tanamanpangan_model->spesifik_Data($id);
				$this->load->view('tanamanpangan/edit', $data);
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
				$this->tanamanpangan_model->hapus_data($id);
				//$this->load->view('tanamanpangan/delete');
				redirect('tanamanpangan');
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}


}
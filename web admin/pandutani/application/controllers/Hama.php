<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
* 
*/
class Hama extends CI_Controller
{
	
	function __construct()
	{
		parent::__construct();

		//load kelas hama_model ke controller Hama
		$this->load->model('hama_model');
		$this->load->helper('url');
	}

	public function index(){
	if($this->session->userdata('username') != '')  
           {  
                $data['data_hama'] = $this->hama_model->tampil_data();
				$this->load->view('hama/index', $data);
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
		            if(!$this->upload->do_upload('gambar_hama'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		                $gambar=$this->upload->file_name;
		            }
				$data['nama_hama'] = $this->input->post('nama_hama');
				$data['uraian_hama'] = $this->input->post('uraian_hama');
				$data['gambar_hama'] = $gambar;
				$data['penanggulangan'] = $this->input->post('penanggulangan');
				$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');
				$this->hama_model->input_data($data);
				}
				redirect('hama');
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
				$this->load->view('hama/tambah');
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
		            if(!$this->upload->do_upload('gambar_hama'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		                $gambar=$this->upload->file_name;
		            }
				$id_hama = $this->input->post('idhama');
				$data['nama_hama'] = $this->input->post('nama_hama');
				$data['uraian_hama'] = $this->input->post('uraian_hama');
				$data['gambar_hama'] = $gambar;
				$data['penanggulangan'] = $this->input->post('penanggulangan');
				$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');

				$this->hama_model->update_data($data, $id_hama);
				}
				redirect('hama');
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
				$data['data'] = $this->hama_model->spesifik_Data($id);
				$this->load->view('hama/edit', $data);
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
				$this->hama_model->hapus_data($id);
				//$this->load->view('hama/delete');
				redirect('hama');
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }	
	}

	public function pilihdropdown()
	{
		if($this->session->userdata('username') != '')  
           {  
				$fk_idtanaman_pangan = $this->input->post('fk_idtanaman_pangan');

           		$datas['data_hamas'] = $this->hama_model->dropdown($fk_idtanaman_pangan);
           		//redirect('hama/dropdown', $datas);
				$this->load->view('hama/dropdown.php', $datas);
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}

}
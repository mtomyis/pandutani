<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
* 
*/
class Prosedur extends CI_Controller
{
	
	function __construct()
	{
		parent::__construct();

		//load kelas prosedur_model ke controller Prosedur
		$this->load->model('prosedur_model');
		$this->load->helper('url');
	}

	public function index()
	{
		if($this->session->userdata('username') != '')  
           {  
				$data['data_prosedur'] = $this->prosedur_model->tampil_data();
				$this->load->view('prosedur/index', $data);
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
		            if(!$this->upload->do_upload('gambar_prosedur'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		                $gambar=$this->upload->file_name;
		            }

				$data['nama_prosedur'] = $this->input->post('nama_prosedur');
				$data['uraian_prosedur'] = $this->input->post('uraian_prosedur');
				$data['gambar_prosedur'] = $gambar;
				$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');
				$this->prosedur_model->input_data($data);
				}
				redirect('prosedur');	
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
				$this->load->view('prosedur/tambah');
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
		            if(!$this->upload->do_upload('gambar_prosedur'))
		            {
		            	$gambar="";
		            }
		            else
		            {
		                $gambar=$this->upload->file_name;
		            }

				$id_prosedur = $this->input->post('idprosedur');
				$data['nama_prosedur'] = $this->input->post('nama_prosedur');
				$data['uraian_prosedur'] = $this->input->post('uraian_prosedur');
				$data['gambar_prosedur'] = $gambar;
				$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');

				$this->prosedur_model->update_data($data, $id_prosedur);
				}
				redirect('prosedur');
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
				$data['data'] = $this->prosedur_model->spesifik_Data($id);
				$this->load->view('prosedur/edit', $data);
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
				$this->prosedur_model->hapus_data($id);
				//$this->load->view('prosedur/delete');
				redirect('prosedur');
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

           		$datas['data_prosedurs'] = $this->prosedur_model->dropdown($fk_idtanaman_pangan);
           		//redirect('hama/dropdown', $datas);
				$this->load->view('prosedur/dropdown.php', $datas);
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}
}
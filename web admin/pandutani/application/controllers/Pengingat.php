<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
* 
*/
class Pengingat extends CI_Controller
{
	
	function __construct()
	{
		parent::__construct();

		//load kelas pengingat_model ke controller Pengingat
		$this->load->model('pengingat_model');
		$this->load->helper('url');
	}

	public function index()
	{
		if($this->session->userdata('username') != '')  
           {  
                $data['data_pengingat'] = $this->pengingat_model->tampil_data();
				$this->load->view('pengingat/index', $data);
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
                $data['nama_pengingat'] = $this->input->post('nama_pengingat');
				$data['jarak_hst'] = $this->input->post('jarak_hst');
				$data['tanggal_mulai'] = $this->input->post('tanggal_mulai');
				$data['tanggal_akhir'] = $this->input->post('tanggal_akhir');
				$data['ciri_tanaman'] = $this->input->post('ciri_tanaman');
				$data['ciri_lahan'] = $this->input->post('ciri_lahan');
				$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');
				$this->pengingat_model->input_data($data);
				redirect('pengingat');	
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
				$this->load->view('pengingat/tambah');
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
			$id_pengingat = $this->input->post('idpengingat');
			$data['nama_pengingat'] = $this->input->post('nama_pengingat');
			$data['jarak_hst'] = $this->input->post('jarak_hst');
			$data['tanggal_mulai'] = $this->input->post('tanggal_mulai');
			$data['tanggal_akhir'] = $this->input->post('tanggal_akhir');
			$data['ciri_tanaman'] = $this->input->post('ciri_tanaman');
			$data['ciri_lahan'] = $this->input->post('ciri_lahan');
			$data['fk_idtanaman_pangan'] = $this->input->post('fk_idtanaman_pangan');
			$this->pengingat_model->update_data($data, $id_pengingat);
			redirect('pengingat');

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
				$data['data'] = $this->pengingat_model->spesifik_Data($id);
				$this->load->view('pengingat/edit', $data);
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
				$this->pengingat_model->hapus_data($id);
				//$this->load->view('pengingat/delete');
				redirect('pengingat');
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

           		$datas['data_pengingats'] = $this->pengingat_model->dropdown($fk_idtanaman_pangan);
           		//redirect('hama/dropdown', $datas);
				$this->load->view('pengingat/dropdown.php', $datas);
           }  
           else  
           {  
                redirect(base_url() . 'main/login');  
           }
	}
}
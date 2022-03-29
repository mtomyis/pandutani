<?php 

class Petani_model extends CI_Model
{
	
	function __construct()
	{
		$this->table='petani';
		parent::__construct();
		//agar koneksi db tersedia untuk keseluruah kelas
		$this->db = $this->load->database('default', TRUE);
	}

	function tampil_data(){
		//fungsi ini sama dengan 'select *from tb_buku'
		$query = $this->db->get($this->table);
		return $query->result();
	}

	function input_data($data){
		$this->db->insert($this->table, $data);
	}

	function spesifik_data($id){
		$query = $this->db->get_where($this->table, array('idpetani' => $id));
		return $query->row();
	}

	function update_data($data, $idpetani){
		$this->db->where('idpetani', $idpetani);
		$this->db->update($this->table, $data);
	}

	function hapus_data($id){
		$this->db->where('idpetani', $id);
		$this->db->delete($this->table);
	}

}
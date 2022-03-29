<?php 

class Hama_model extends CI_Model
{
	
	function __construct()
	{
		$this->table='hama';
		parent::__construct();
		//agar koneksi db tersedia untuk keseluruah kelas
		$this->db = $this->load->database('default', TRUE);
	}

	function tampil_data(){
		//fungsi ini sama dengan 'select *from tb_buku'
		return $this->db->query("SELECT * FROM `hama` LEFT JOIN tanamanpangan on hama.fk_idtanaman_pangan = tanamanpangan.idtanaman_pangan")->result();
	}

	function input_data($data){
		$this->db->insert($this->table, $data);
	}

	function spesifik_data($id){
		$query = $this->db->get_where($this->table, array('idhama' => $id));
		return $query->row();
	}

	function update_data($data, $idhama){
		$this->db->where('idhama', $idhama);
		$this->db->update($this->table, $data);
	}

	function hapus_data($id){
		$this->db->where('idhama', $id);
		$this->db->delete($this->table);
	}

	function dropdown($fk_idtanaman_pangan){
		//fungsi ini sama dengan 'select *from tb_buku'
		// $this->db->get($this->table);
		// $this->db->where('fk_idtanaman_pangan', $fk_idtanaman_pangan);

		return $this->db->query("SELECT * FROM `hama` LEFT JOIN tanamanpangan on hama.fk_idtanaman_pangan = tanamanpangan.idtanaman_pangan where fk_idtanaman_pangan = '$fk_idtanaman_pangan'")->result();
	}

}
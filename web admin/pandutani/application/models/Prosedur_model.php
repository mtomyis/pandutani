<?php 

class Prosedur_model extends CI_Model
{
	
	function __construct()
	{
		$this->table='prosedur';
		parent::__construct();
		//agar koneksi db tersedia untuk keseluruah kelas
		$this->db = $this->load->database('default', TRUE);
	}

	function tampil_data(){
		//fungsi ini sama dengan 'select *from tb_buku'
		return $this->db->query("SELECT * FROM `prosedur` LEFT JOIN tanamanpangan on prosedur.fk_idtanaman_pangan = tanamanpangan.idtanaman_pangan")->result();
		// $query = $this->db->get($this->table);
		// return $query->result();
	}

	function input_data($data){
		$this->db->insert($this->table, $data);
	}

	function spesifik_data($id){
		$query = $this->db->get_where($this->table, array('idprosedur' => $id));
		return $query->row();
	}

	function update_data($data, $idprosedur){
		$this->db->where('idprosedur', $idprosedur);
		$this->db->update($this->table, $data);
	}

	function hapus_data($id){
		$this->db->where('idprosedur', $id);
		$this->db->delete($this->table);
	}

	function dropdown($fk_idtanaman_pangan){
		//fungsi ini sama dengan 'select *from tb_buku'
		// $this->db->get($this->table);
		// $this->db->where('fk_idtanaman_pangan', $fk_idtanaman_pangan);

		return $this->db->query("SELECT * FROM `prosedur` LEFT JOIN tanamanpangan on prosedur.fk_idtanaman_pangan = tanamanpangan.idtanaman_pangan where fk_idtanaman_pangan = '$fk_idtanaman_pangan'")->result();
	}

}
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8"><title>AdminLTE</title><!--[if IE 8]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"><meta name="google" content="notranslate">
	<meta name="robots" content="noindex, nofollow">
	<link rel="icon" href="data:image/x-icon;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAqElEQVRYR+2WYQ6AIAiF8W7cq7oXd6v5I2eYAw2nbfivYq+vtwcUgB1EPPNbRBR4Tby2qivErYRvaEnPAdyB5AAi7gCwvSUeAA4iis/TkcKl1csBHu3HQXg7KgBUegVA7UW9AJKeA6znQKULoDcDkt46bahdHtZ1Por/54B2xmuz0uwA3wFfd0Y3gDTjhzvgANMdkGb8yAyY/ro1d4H2y7R1DuAOTHfgAn2CtjCe07uwAAAAAElFTkSuQmCC">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,700italic">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/ionicons/css/ionicons.min.css">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/adminlte/css/adminlte.min.css">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/adminlte/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<?php echo base_url(); ?>assets/frameworks/domprojects/css/dp.min.css"><!--[if lt IE 9]><script src="<?php echo base_url(); ?>assets/plugins/html5shiv/html5shiv.min.js"></script><script src="<?php echo base_url(); ?>assets/plugins/respond/respond.min.js"></script><![endif]-->
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<div class="wrapper"><header class="main-header"><a href="<?php echo base_url(); ?>dashboard" class="logo"><span class="logo-mini">
		<b>P</b>tani</span><span class="logo-lg"><b>Pandu</b>Taniwangi</span></a>
		<nav class="navbar navbar-static-top" role="navigation"><a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"><span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a><div class="navbar-custom-menu">
			<ul class="nav navbar-nav"><!-- User Account -->
				<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><!-- <img src="<?php echo base_url(); ?>upload/avatar/m_001.png" class="user-image" alt="User Image"> --><span class="hidden-xs">administrator</span></a>
				<ul class="dropdown-menu"><li class="user-header"><!-- <img src="<?php echo base_url(); ?>upload/avatar/m_001.png" class="img-circle" alt="User Image"> -->
					<p>Admin istrator<!-- <small>Member since 18-03-2010</small> --></p><p><a href="<?php echo base_url(); ?>dashboard/logout" class="btn btn-default btn-flat">Sign out</a></p></li></ul></li></ul></div></nav></header>
			<aside class="main-sidebar">
				<section class="sidebar"><!-- Sidebar menu --><ul class="sidebar-menu">
				<li class="header text-uppercase">Kelola Data</li>
				<li class=""><a href="<?php echo base_url(); ?>tanamanpangan"><i class="fa fa-file"></i> <span>Tanaman Pangan</span></a></li>
				<li class="active"><a href="<?php echo base_url(); ?>prosedur"><i class="fa fa-file"></i> <span>Prosedur</span></a></li>
				<li class=""><a href="<?php echo base_url(); ?>hama"><i class="fa fa-file"></i> <span>Hama Tanaman</span></a></li>
				<li class=""><a href="<?php echo base_url(); ?>petani"><i class="fa fa-file"></i> <span>Pengguna</span></a></li>
				<li class=""><a href="<?php echo base_url(); ?>pengingat"><i class="fa fa-file"></i> <span>Pengingat</span></a><!-- mulai dari sini --></ul></section></aside><div class="content-wrapper">
					<section class="content-header"><h1>Prosedur</h1><ol class="breadcrumb"><li><a href="<?php echo base_url(); ?>dashboard"><i class="fa fa-dashboard"></i> Dashboard</a> </li><li><a href="<?php echo base_url(); ?>prosedur">Prosedur</a> </li><li class="active">Edit</li></ol></section>
					<section class="content"><div class="row"><div class="col-md-12"> <div class="box"><div class="box-header with-border"><h3 class="box-title">Edit</h3> </div><div class="box-body">
						
	<form action="<?php echo base_url(); ?>prosedur/update" class="form-horizontal" id="form-create_group" method="post" accept-charset="utf-8" enctype="multipart/form-data">

		<!-- <div class="form-group">
		<label for="Idprosedur" class="col-sm-2 control-label">Id Prosedur</label>
		<div class="col-sm-10"> -->
			<input type="hidden" name="idprosedur" id="Idprosedur" class="form-control" value="<?php echo $data->idprosedur; ?>" />
		<!-- </div></div> -->
		<div class="form-group">
		<label for="nama" class="col-sm-2 control-label">Nama</label>
		<div class="col-sm-10">
			<input type="text" name="nama_prosedur" id="nama" class="form-control"  value="<?php echo $data->nama_prosedur; ?>" />
		</div></div>
		<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Deskripsi</label>
		<div class="col-sm-10">
			<textarea type="text" name="uraian_prosedur" value="<?php echo $data->uraian_prosedur; ?>" id="description" class="form-control"><?php echo $data->uraian_prosedur; ?></textarea>
		</div></div>
		<div class="form-group">
		<label for="fk" class="col-sm-2 control-label">FK Idtanaman Pangan</label>
		<div class="col-sm-10">
			<select name="fk_idtanaman_pangan" id="fk" class="form-control">

           					<option ><?php echo $data->fk_idtanaman_pangan;?></option>

                			<?php  $kt=$this->db->get('tanamanpangan');
								foreach ($kt->result() as $k){?>
           			<option value="<?php echo $k->idtanaman_pangan;?>"><?php echo $k->nama_tanaman;?> = <?php echo $k->idtanaman_pangan;?></option>
			           <?php }?>
           	</select>

			<!-- ini seharusnya radiobox -->
			<!-- <input type="text" name="idprosedur" id="fk" class="form-control" value="<?php echo $data->fk_idtanaman_pangan; ?>" /> -->

		</div></div>
		<div class="form-group">
		<label for="gambar" class="col-sm-2 control-label">Gambar</label>
		<div class="col-sm-10">
			<input type="file" name="gambar_prosedur" id="gambar" />
		</div></div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="btn-group">
					<button type="submit" name="submit" class="btn btn-primary btn-flat" >Submit</button>
					<button type="reset" class="btn btn-warning btn-flat" >Reset</button>
					<a href="<?php echo base_url(); ?>prosedur" class="btn btn-default btn-flat">Cancel</a>
				</div>
			</div>
		</div>

	</form>
</div></div></div></div></section></div>
<footer class="main-footer"><div class="pull-right hidden-xs"><b>version</b> Development</div>
	<strong>Copyright &copy; 2019 Politeknik Negeri Banyuwangi.</strong> All rights reserved.</footer></div>
	<script src="<?php echo base_url(); ?>assets/frameworks/jquery/jquery.min.js"></script>
	<script src="<?php echo base_url(); ?>assets/frameworks/bootstrap/js/bootstrap.min.js"></script>
	<script src="<?php echo base_url(); ?>assets/plugins/slimscroll/slimscroll.min.js"></script>
	<script src="<?php echo base_url(); ?>assets/frameworks/adminlte/js/adminlte.min.js"></script>
	<script src="<?php echo base_url(); ?>assets/frameworks/domprojects/js/dp.min.js"></script></body></html>
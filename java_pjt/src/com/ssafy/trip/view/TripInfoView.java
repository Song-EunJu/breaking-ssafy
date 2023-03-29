package com.ssafy.trip.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.dto.TripSearchDto;
import com.ssafy.trip.model.service.TripService;
import com.ssafy.trip.model.service.TripServiceImpl;

public class TripInfoView {

	/** model들 */
	private TripService tripService;

	/** main 화면 */
	private JFrame frame;

	/** 관광지 이미지 표시 Panel */
	private JLabel imgL;
	private JLabel[] tripInfoL;

	/** 조회 조건 */
	private JComboBox<String> findC;
	private JTextField wordTf;
	private JButton searchBt;

	/** 조회 내용 표시할 table */
	private DefaultTableModel tripModel;
	private JTable tripTable;
	private JScrollPane tripPan;
	private String[] title = { "번호", "관광지명", "도로명주소", "지번주소", "전화번호" };

	/** 검색 조건 */
	private String key;
	private String[] choice = { "검색조건선택", "관광지명", "주소" };
	/** 검색할 단어 */
	private String word;

	/** 화면에 표시하고 있는 주택 */
	private TripDto curTrip;

	public TripInfoView() {
		/* Service들 생성 */
		tripService = new TripServiceImpl();

		/* 메인 화면 설정 */
		frame = new JFrame("Enjoy! Trip - 즐거운 여행");
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				frame.dispose();
//			}
//		});

		setMain();

		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showTripInfo(0);
	}

	private void showTripInfo(int num) {
		curTrip = tripService.search(num);

		tripInfoL[0].setText("");
		tripInfoL[1].setText("");
		tripInfoL[2].setText(curTrip.getTouristDestination());
		tripInfoL[3].setText(curTrip.getStreetAddress());
		tripInfoL[4].setText(curTrip.getLotAddress());
		tripInfoL[5].setText(curTrip.getLat() + "");
		tripInfoL[6].setText(curTrip.getLng() + "");
		tripInfoL[7].setText(curTrip.getTel());
		tripInfoL[8].setText(curTrip.getInfo());
		tripInfoL[9].setText("");

		ImageIcon icon = null;
		if (curTrip.getImg() != null && curTrip.getImg().trim().length() != 0) {
			String img = curTrip.getImg();
			File file = new File("img", img);

			if (!file.exists())
				img = "no_image.jpg";
			icon = new ImageIcon("img/" + img);

		} else {
			String str = "img/image0"+((int)(Math.random()*9)+1)+".jpg";
			icon = new ImageIcon(str);
		}
		Image image = icon.getImage();
		Image changeImage = image.getScaledInstance(570, 470, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		imgL.setIcon(changeIcon);
	}

	/** 메인 화면인 관광지 목록을 위한 화면 셋팅하는 메서드 */
	public void setMain() {

		/* 왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new BorderLayout(0, 10));
		JPanel leftR = new JPanel(new GridLayout(10, 2));
		leftR.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		String[] info = { "", "", "관광지명", "도로명주소", "지번주소", "위도", "경도", "전화번호", "관광지정보", "" };
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		tripInfoL = new JLabel[size];
		for (int i = 0; i < size; i++) {
			infoL[i] = new JLabel(info[i]);
			tripInfoL[i] = new JLabel("");
			leftR.add(infoL[i]);
			leftR.add(tripInfoL[i]);
		}
		imgL = new JLabel();
		leftCenter.add(imgL, "Center");
		leftCenter.add(leftR, "South");

		left.add(new JLabel("관광지 정보", JLabel.CENTER), "North");
		left.add(leftCenter, "Center");

		/* 오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));

		JPanel rightTop2 = new JPanel(new GridLayout(1, 3));
		String[] item = { "검색조건선택", "관광지명", "주소" };
		findC = new JComboBox<String>(item);
		wordTf = new JTextField();
		searchBt = new JButton("검색");

		rightTop2.add(findC);
		rightTop2.add(wordTf);
		rightTop2.add(searchBt);

		rightTop.add(new Label(""));
		rightTop.add(new Label(""));
		rightTop.add(rightTop2);
		rightTop.add(new Label(""));

		JPanel rightCenter = new JPanel(new BorderLayout());
		tripModel = new DefaultTableModel(title, 20);
		tripTable = new JTable(tripModel);
		tripPan = new JScrollPane(tripTable);
		tripTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("광광지 정보", JLabel.CENTER), "North");
		rightCenter.add(tripPan, "Center");

		right.add(rightTop, "North");
		right.add(rightCenter, "Center");

		JPanel mainP = new JPanel(new GridLayout(1, 2));

		mainP.add(left);
		mainP.add(right);

		mainP.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		frame.add(mainP, "Center");

		tripTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = tripTable.getSelectedRow();
				int code = Integer.parseInt(((String) tripModel.getValueAt(row, 0)).trim());
				showTripInfo(code);
			}
		});

		// complete code #01
		// 아래의 코드를 참조하여 아래 라인을 uncomment 하고 searchBt.addActionList() 를 Lambda 표현식으로 바꾸세요.
		
		//TODO 1
		searchBt.addActionListener((ActionEvent e)->searchTrips());

		showTrips();
	}

	/** 검색 조건에 맞는 관광지 검색 */
	private void searchTrips() {
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		showTrips();
	}

	/**
	 * 관광지 목록을 갱신하기 위한 메서드
	 */
	public void showTrips() {
		TripSearchDto tripSearchDto = new TripSearchDto();
		if (key != null) {
			if (key.equals("관광지명")) {
				tripSearchDto.setTouristDestination(word);
			} else if (key.equals("주소")) {
				tripSearchDto.setSido(word);
			}
		}

		if (word == null || word.trim().length() == 0)
			findC.setSelectedIndex(0);

		List<TripDto> trips = tripService.searchAll(tripSearchDto);
		if (trips != null) {
			int i = 0;
			String[][] data = new String[trips.size()][5];
			for (TripDto trip : trips) {
				data[i][0] = "" + trip.getNum();
				data[i][1] = trip.getTouristDestination();
				data[i][2] = trip.getStreetAddress();
				data[i][3] = trip.getLotAddress();
				data[i++][4] = trip.getTel();
			}
			tripModel.setDataVector(data, title);
		}
	}

//	public static void main(String[] args) {
//		new TripInfoView();
//	}
}

import React, { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";
import {
  Card,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";

const DOMAIN = "http://localhost:8080";
const BOOK_API = "api/test/books";

interface GetBookResponseDto {
  book_title: string;
  book_author: string;
  category: string;
}

function App() {
  const [result, setResult] = useState<GetBookResponseDto[]>([]);

  useEffect(() => {
    const fetchBookData = async () => {
      try {
        const response = await axios.get(`${DOMAIN}/${BOOK_API}`);
        const data = response.data; // 필요에 따라 수정
        setResult(data);
      } catch (error) {
        console.error("Error fetching data: ", error);
        setResult([]);
      }
    };

    fetchBookData();
  }, []);

  console.log(result);
  return (
    <Card
      variant="outlined"
      sx={{
        width: 500,
        m: "auto",
        mt: 5,
      }}
    >
      <Typography variant="h4" mb={3} sx={{borderBottom: '2px solid black', 'padding': '8px'}}>
        전체 책 조회
      </Typography>

      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>제목</TableCell>
              <TableCell>저자</TableCell>
              <TableCell>카테고리</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {result.map((result, index) => (
              <TableRow key={index}>
                <TableCell>{result.book_title}</TableCell>
                <TableCell>{result.book_author}</TableCell>
                <TableCell>{result.category}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Card>
  );
}

export default App;

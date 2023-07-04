# Sirket Yonetim Sistemi
Genel Tanım
Şirket Yönetim Sistemi, şirketlerin yönetimini ve çalışan bilgilerini takip etmek için bir web uygulamasıdır. Bu uygulama, MVC (Model-View-Controller) modelini kullanarak şirket verilerinin saklanması, işlenmesi ve sunulması için bir yapı sunar.
MVC Modeli, uygulamanın kodunun farklı katmanlara ayrılmasını ve her bir katmanın belirli bir rolü üstlenmesini sağlar. Şirket Yönetim Sistemi, aşağıdaki bileşenleri içerir:
Model: Şirket ve Çalışan sınıflarını içeren Company ve Employee sınıfları, şirket ve çalışan verilerinin temsili için kullanılır. CompanyRepository ve EmployeeRepository aracılığıyla veritabanı işlemleri gerçekleştirilir.
View: Kullanıcı arayüzü (UI) katmanıdır. Bu örnekte, View katmanı yerine RESTful API kullanılmaktadır. İstemci tarafından gönderilen HTTP istekleri ve alınan HTTP yanıtları ile iletişim sağlanır.
Controller: İstemciden gelen istekleri alır, ilgili iş mantığı metotlarını çağırır ve sonuçları istemciye döndürür. CompanyController ve EmployeeController sınıfları, ilgili işlemleri gerçekleştirir.
Service: İş mantığı metotlarının uygulandığı katmandır. CompanyService ve EmployeeService sınıfları, ilgili iş mantığı işlemlerini gerçekleştirir. Bu sınıflar, ilgili Repository sınıflarını kullanarak veritabanı işlemleri yapar.
Uygulama, şirketleri ve çalışanları eklemek, güncellemek, silmek ve listelemek için kullanılabilir. RESTful API, HTTP istekleriyle etkileşim sağlar ve JSON formatında veri döndürür.

Proje Yapısı
Projede aşağıdaki sınıflar ve paketler kullanılmaktadır:
com.example.model: Model sınıflarını ve veritabanı işlemleri için gerekli olan CompanyRepository ve EmployeeRepository arayüzlerini içerir.
com.example.model.Company: Şirket sınıfını temsil eder ve şirket bilgilerini tutar.
com.example.model.CompanyService: Şirket iş mantığı metotlarını içeren servis sınıfıdır.
com.example.model.CompanyController: Şirket ile ilgili HTTP isteklerini karşılayan controller sınıfıdır.
com.example.model.Employee: Çalışan sınıfını temsil eder ve çalışan bilgilerini tutar.
com.example.model.EmployeeService: Çalışan iş mantığı metotlarını içeren servis sınıfıdır.
com.example.model.EmployeeController: Çalışan ile ilgili HTTP isteklerini karşılayan controller sınıfıdır.
com.example.model.Uygulama: Uygulamanın başlangıç noktasını temsil eder.
API Endpointleri ve İstekler
Aşağıda, Şirket Yönetim Sistemi'nin kullanılabilir API endpointlerini ve ilgili HTTP isteklerini gösteren bir örnek verilmiştir:
Şirketler
GET /companies: Tüm şirketleri getirir.
GET /companies/{id}: Belirli bir şirketi ID'siyle getirir.
POST /companies: Yeni bir şirket ekler.
PUT /companies/{id}: Belirli bir şirketi günceller.
DELETE /companies/{id}: Belirli bir şirketi siler.
Çalışanlar
GET /companies/{companyId}/employees: Belirli bir şirketin tüm çalışanlarını getirir.
GET /companies/{companyId}/employees/{employeeId}: Belirli bir şirketin belirli bir çalışanını getirir.
POST /companies/{companyId}/employees: Belirli bir şirkete yeni bir çalışan ekler.
PUT /companies/{companyId}/employees/{employeeId}: Belirli bir şirketin belirli bir çalışanını günceller.
DELETE /companies/{companyId}/employees/{employeeId}: Belirli bir şirketin belirli bir çalışanını siler.

 
Model Katmanı
Şirket (Company) Sınıfı
Company sınıfı, bir şirketi temsil eder ve şirketin bilgilerini tutar.
Özellikler (Properties)
id: Şirketin benzersiz kimliğini temsil eden bir Long değeri.
name: Şirketin adını temsil eden bir String değeri.
address: Şirketin adresini temsil eden bir String değeri.
employees: Şirkete ait çalışanları temsil eden bir List<Employee> nesnesi.
İlişkiler (Relationships)
employees: Şirkete ait çalışanları temsil eden bir OneToMany ilişkisi. Şirketin birden çok çalışanı olabilir.
Çalışan (Employee) Sınıfı
Employee sınıfı, bir çalışanı temsil eder ve çalışanın bilgilerini tutar.
Özellikler (Properties)
id: Çalışanın benzersiz kimliğini temsil eden bir Long değeri.
name: Çalışanın adını temsil eden bir String değeri.
position: Çalışanın pozisyonunu temsil eden bir String değeri.
salary: Çalışanın maaşını temsil eden bir Double değeri.
company: Çalışanın bağlı olduğu şirketi temsil eden bir Company nesnesi.
İlişkiler (Relationships)
company: Çalışanın bağlı olduğu şirketi temsil eden bir ManyToOne ilişkisi. Bir şirkete birden çok çalışan bağlı olabilir.
Veri Erişim Katmanı
Veri erişim katmanında CompanyRepository ve EmployeeRepository arayüzleri kullanılır. Bu arayüzler, veritabanı işlemlerini gerçekleştirmek için Spring Data JPA tarafından sağlanan JpaRepository sınıfını genişletir.
CompanyRepository: Şirketlerle ilgili veritabanı işlemlerini gerçekleştirmek için kullanılır.
EmployeeRepository: Çalışanlarla ilgili veritabanı işlemlerini gerçekleştirmek için kullanılır.
İş Mantığı
İş mantığı işlemleri, servis sınıflarında gerçekleştirilir. CompanyService ve EmployeeService sınıfları, ilgili iş mantığı işlemlerini gerçekleştirir. Bu sınıflar, veri erişim katmanıyla iletişim kurarak veri işlemlerini gerçekleştirir.


CompanyService Sınıfı
CompanyService sınıfı, şirketlerle ilgili iş mantığı işlemlerini gerçekleştirir. Aşağıda bazı örnek işlemler bulunmaktadır:
saveCompany(Company company): Şirket kaydetme işlemini gerçekleştirir. Veriyi veri erişim katmanına ileterek kaydedilmesini sağlar.
getAllCompanies(): Tüm şirketleri getirme işlemini gerçekleştirir. Veriyi veri erişim katmanından alır ve geri döndürür.
deleteCompany(Long companyId): Şirket silme işlemini gerçekleştirir. Veri erişim katmanına silme işlemini ileterek şirketi siler.
EmployeeService Sınıfı
EmployeeService sınıfı, çalışanlarla ilgili iş mantığı işlemlerini gerçekleştirir. Aşağıda bazı örnek işlemler bulunmaktadır:
saveEmployee(Employee employee): Çalışan kaydetme işlemini gerçekleştirir. Veriyi veri erişim katmanına ileterek kaydedilmesini sağlar.
getAllEmployees(): Tüm çalışanları getirme işlemini gerçekleştirir. Veriyi veri erişim katmanından alır ve geri döndürür.
deleteEmployee(Long employeeId): Çalışan silme işlemini gerçekleştirir. Veri erişim katmanına silme işlemini ileterek çalışanı siler.
Bu sınıflar, controller sınıfları aracılığıyla dış dünyayla iletişim kurar ve HTTP isteklerine yanıt verir. Controller sınıfları, gelen istekleri uygun servis metodlarına yönlendirir ve sonuçları HTTP yanıtlarına dönüştürerek istemcilere gönderir.

 
Controller Katmanı
Controller sınıfları, gelen HTTP isteklerini yönetir, iş mantığı sınıflarına istekleri ileterek ilgili işlemleri gerçekleştirir ve sonuçları HTTP yanıtlarına dönüştürerek istemcilere gönderir. Aşağıda, bir örnek olarak CompanyController sınıfı üzerinden controller katmanının rolünü ve görevlerini açıklayalım.
CompanyController Sınıfı
CompanyController sınıfı, şirketlere ait endpointlerin tanımlandığı ve bu endpointlere gelen isteklere nasıl cevap verildiğinin belirtildiği sınıftır.
Anotasyonlar ve İşlevleri
@RestController: Sınıf seviyesinde kullanılan bir anotasyondur ve bu sınıfın bir RESTful API controller'ı olduğunu belirtir. Sınıfın metodları, HTTP yanıtları olarak döndürülecektir.
@RequestMapping("/companies"): Sınıf seviyesinde kullanılan bir anotasyondur ve /companies yolunu tanımlar. Bu yol, controller'daki tüm endpointlere ön ek olarak eklenir.
@Autowired: Sınıfın constructor'ında kullanılan bir anotasyondur ve bağımlılıkların otomatik olarak enjekte edilmesini sağlar. CompanyService sınıfına bağımlılığın otomatik olarak enjekte edilmesini sağlar.
Endpointler ve İşlevleri
@GetMapping: HTTP GET isteğini karşılar ve ilgili endpointin tanımlandığı metodu işaretler.
@PostMapping: HTTP POST isteğini karşılar ve ilgili endpointin tanımlandığı metodu işaretler.
@PutMapping: HTTP PUT isteğini karşılar ve ilgili endpointin tanımlandığı metodu işaretler.
@DeleteMapping: HTTP DELETE isteğini karşılar ve ilgili endpointin tanımlandığı metodu işaretler.
@PathVariable: Yol parametresini almak için kullanılır. Endpointin URL'sindeki değişkenleri yakalamak için kullanılır.
@RequestBody: HTTP isteği gövdesindeki veriyi almak için kullanılır. JSON veya XML gibi formatlardan veriyi dönüştürerek alır.
Aşağıda, CompanyController sınıfındaki örnek endpointlerin tanımları ve görevleri bulunmaktadır:
@GetMapping: Tüm şirketleri getirmek için kullanılır. /companies endpointi ile eşleşir. getAllCompanies() metodu ile ilişkilendirilir ve tüm şirketleri döndürür.
@GetMapping("/{id}"): Belirli bir şirketi getirmek için kullanılır. /companies/{id} endpointi ile eşleşir. getCompanyById(Long id) metodu ile ilişkilendirilir ve belirtilen id'ye sahip şirketi döndürür.
@PostMapping: Yeni bir şirket eklemek için kullanılır. /companies endpointi ile eşleşir. addCompany(Company company) metodu ile ilişkilendirilir ve yeni eklenen şirketi döndürür.
@PutMapping("/{id}"): Var olan bir şirketi güncellemek için kullanılır. /companies/{id} endpointi ile eşleşir. updateCompany(Long id, Company company) metodu ile ilişkilendirilir ve güncellenen şirketi döndürür.
@DeleteMapping("/{id}"): Var olan bir şirketi silmek için kullanılır. /companies/{id} endpointi ile eşleşir. deleteCompany(Long id) metodu ile ilişkilendirilir ve şirketin silinip silinmediğini döndürür.
 
Servis Katmanı
Servis katmanı, iş mantığının uygulandığı ve veri erişim katmanıyla iletişim kurulan yerdir. Bu katmanda, işlemlerin gerçekleştirildiği ve verilerin işlendiği metotlar bulunur. Aşağıda, bir örnek olarak CompanyService sınıfı üzerinden servis katmanının görevlerini ve kullanımını açıklayalım.
CompanyService Sınıfı
CompanyService sınıfı, şirketlerle ilgili iş mantığının uygulandığı ve veri erişim katmanıyla iletişim kurulan sınıftır.
Anotasyonlar ve İşlevleri
@Service: Sınıf seviyesinde kullanılan bir anotasyondur ve bu sınıfın bir servis sınıfı olduğunu belirtir. Bu sınıf, iş mantığını uygulayan metotları içerir.
Metotlar ve İşlevleri
saveCompany(Company company): Yeni bir şirketi kaydetmek için kullanılır. Veri erişim katmanı üzerinden companyRepository.save(company) metodu çağrılarak şirket kaydedilir ve kaydedilen şirket döndürülür.
getAllCompanies(): Tüm şirketleri getirmek için kullanılır. Veri erişim katmanı üzerinden companyRepository.findAll() metodu çağrılarak tüm şirketler alınır ve liste olarak döndürülür.
deleteCompany(Long companyId): Bir şirketi silmek için kullanılır. Veri erişim katmanı üzerinden companyRepository.deleteById(companyId) metodu çağrılarak şirket silinir. Şirket başarıyla silindiğinde true, silinemediğinde veya hata oluştuğunda false döndürülür.
getCompanyById(Long id): Belirli bir şirketi id'ye göre getirmek için kullanılır. Veri erişim katmanı üzerinden companyRepository.findById(id) metodu çağrılarak şirket bulunur ve eğer varsa şirket döndürülür. Eğer şirket bulunamazsa null döndürülür.
updateCompany(Long id, Company updatedCompany): Var olan bir şirketi güncellemek için kullanılır. İlk olarak, güncellenecek şirketin veritabanından getirilmesi sağlanır. Ardından, güncellenmiş verilerle mevcut şirketin alanları güncellenir ve companyRepository.save(existingCompany) metodu çağrılarak güncellenen şirket veritabanına kaydedilir. Şirket başarıyla güncellendiğinde true, güncellenemediğinde veya şirket bulunamadığında false döndürülür.

